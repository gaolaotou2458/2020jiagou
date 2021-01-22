package com.gupaoedu.vip.spring.formework.context;


import com.gupaoedu.vip.spring.formework.annotation.GPAutowired;
import com.gupaoedu.vip.spring.formework.annotation.GPController;
import com.gupaoedu.vip.spring.formework.annotation.GPService;
import com.gupaoedu.vip.spring.formework.beans.config.GPBeanPostProcessor;
import com.gupaoedu.vip.spring.formework.core.GPBeanFactory;
import com.gupaoedu.vip.spring.formework.beans.GPBeanWrapper;
import com.gupaoedu.vip.spring.formework.beans.config.GPBeanDefinition;
import com.gupaoedu.vip.spring.formework.beans.support.GPBeanDefinitionReader;
import com.gupaoedu.vip.spring.formework.beans.support.GPDefaultListableBeanFactory;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: GPApplicationContext
 * @Description: 最底层容器实现
 * 按照之前源码分析的套路 IOC DI MVC AOP
 * @Author: xuxk
 * @Date: 2021-01-18 09:04
 * @Version: 1.0
 **/
public class GPApplicationContext extends GPDefaultListableBeanFactory implements GPBeanFactory {

    private String[] configLOcations;

    private GPBeanDefinitionReader reader;
    // 单例的IOC容器
    private Map<String,Object> singletonObjects = new ConcurrentHashMap<>();
    // 普通的IOC容器
    private Map<String,GPBeanWrapper> factoryBeanInstanceCache = new ConcurrentHashMap<>();


    public GPApplicationContext(String ... configLOcations){
        this.configLOcations = configLOcations;
        refresh();
    }

    //IOC 流程
    @Override
    public void refresh() {
        // 1、定位，定位配置文件
        reader = new GPBeanDefinitionReader(configLOcations);
        // 2、加载配置文件，扫描相关的类、把他们封装成BeanDefinition
        List<GPBeanDefinition> beanDefinitions = reader.loadBeanDefinitions();
        // 3、注册，把配置信息放到容器里面（伪IOC容器）
        try {
            doRegisterBeanDefinition(beanDefinitions);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 4、把不是延时加载的类，都提前初始化
        doAutowrited();

    }

    //只处理非延时加载的情况
    private void doAutowrited() {
        super.beanDefinitionMap.forEach((beanName,beanDefinition) -> {
            if(!beanDefinition.isLazyInit()) {
                try {
                    getBean(beanName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void doRegisterBeanDefinition(List<GPBeanDefinition> beanDefinitions) throws Exception {
//        beanDefinitions.forEach(beanDefinition ->{
//            super.beanDefinitionMap.put(beanDefinition.getFactoryBeanName(),beanDefinition);
//        });
        for (GPBeanDefinition beanDefinition: beanDefinitions) {
            if(super.beanDefinitionMap.containsKey(beanDefinition.getFactoryBeanName())){
                throw new Exception("The “" + beanDefinition.getFactoryBeanName() + "” is exists!!");
            }
            super.beanDefinitionMap.put(beanDefinition.getFactoryBeanName(),beanDefinition);
        }

    }

    @Override
    public Object getBean(Class<?> beanClass) throws Exception{
        return getBean(beanClass.getName());
    }


    @Override
    public Object getBean(String beanName) throws Exception {
        //1、 初始化
        GPBeanDefinition beanDefinition = this.beanDefinitionMap.get(beanName);
        Object  instance = null;
        //Class A {B b}
        //Class B {A a}
        //工厂模式 + 策略模式
        GPBeanPostProcessor postProcessor = new GPBeanPostProcessor();
        postProcessor.postProcessBeforeInitialization(instance,beanName);
        instance = instantiateBean(beanName, beanDefinition);
        //对象封装到BeanWrapper
        GPBeanWrapper gpBeanWrapper = new GPBeanWrapper(instance);
        //2. 拿到BeanWrapperz'之后，把BeanWrapper存到IOC容器
        this.factoryBeanInstanceCache.put(beanName,gpBeanWrapper);
        //this.factoryBeanInstanceCache.put(this.beanDefinitionMap.get(beanName).getBeanClassName(),gpBeanWrapper);
        //2、注入
        populateBean(beanName, new GPBeanDefinition(), gpBeanWrapper);
        //doCreateBean

        return this.factoryBeanInstanceCache.get(beanName).getWrappedInstance();
    }

    //方法复制Sptring 暂时不去掉无用参数
    private void populateBean(String beanName, GPBeanDefinition gpBeanDefinition, GPBeanWrapper gpBeanWrapper) {
        Object instance = gpBeanWrapper.getWrappedInstance();

        gpBeanDefinition.getBeanClassName();

        Class<?> clazz = gpBeanWrapper.getWrappedClass();
        // 判断只有加了注解的类，才执行依赖注入
        if(!(clazz.isAnnotationPresent(GPController.class) || clazz.isAnnotationPresent(GPService.class))){
            return;
        }

        // 获得所有的fields
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if(!field.isAnnotationPresent(GPAutowired.class)) {continue;}
            //现在暂时只做一个注解，
            GPAutowired autowired = field.getAnnotation(GPAutowired.class);
            String autowiredBeanName = autowired.value().trim();
            if("".equals(autowiredBeanName)){
                autowiredBeanName = field.getType().getName();
            }
            field.setAccessible(true);
            try {
                if(instance == null) {
                    continue;
                }
                if(this.factoryBeanInstanceCache.get(autowiredBeanName) == null) continue;
                field.set(instance,this.factoryBeanInstanceCache.get(autowiredBeanName).getWrappedInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }


    }

    private Object instantiateBean(String beanName, GPBeanDefinition gpBeanDefinition) {
        // 1.拿到要实例化的对象的类名

        String className = gpBeanDefinition.getBeanClassName();
        // 2、反射实例化 得到一个对象
        Object instance = null;
        try {
            //假设默认就是单例，细节暂时不考虑
            if(this.singletonObjects.containsKey(className)){
                instance = this.singletonObjects.get(className);
            } else {
                Class<?> clazz = Class.forName(className);
                instance = clazz.newInstance();
                singletonObjects.put(className,instance);
                singletonObjects.put(gpBeanDefinition.getFactoryBeanName(),instance);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //4、吧BeanWrapper存户到IOC容器中

        return instance;
    }

    public String[] getBeanDefinitionNames() {
        return this.beanDefinitionMap.keySet().toArray(new String[this.beanDefinitionMap.size()]);
    }

    public int getBeanDefinitionCount(){
        return this.beanDefinitionMap.size();
    }


    public Properties getConfig(){
        return this.reader.getConfig();
    }
}
