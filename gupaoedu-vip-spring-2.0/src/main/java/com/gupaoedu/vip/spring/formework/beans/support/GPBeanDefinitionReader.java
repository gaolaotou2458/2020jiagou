package com.gupaoedu.vip.spring.formework.beans.support;

import com.gupaoedu.vip.spring.formework.beans.config.GPBeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @ClassName: GPBeanDefinitionReader
 * @Description:
 * @Author: xuxk
 * @Date: 2021-01-18 13:32
 * @Version: 1.0
 **/
public class GPBeanDefinitionReader {

    private List<String> registyBeanClasses = new ArrayList<>();

    private Properties config = new Properties();



    //固定配置文件中的key，相当于xml中的规范
    private final String SCAN_PACKAGE = "scanPackage";

    public GPBeanDefinitionReader(String... locations){
        // 通过URL定位找到其所对应的文件，转化韦文件流，读取
        try (InputStream is = this.getClass().getClassLoader().
                getResourceAsStream(locations[0].replace("classpath:", ""));) {
            config.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        doScanner(config.getProperty(SCAN_PACKAGE));

    }




    private void doScanner(String scanPackage) {
        //URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.","/"));
        URL url = this.getClass().getResource("/" + scanPackage.replaceAll("\\.","/"));
        File classDir = new File(url.getFile());
        for (File file : classDir.listFiles()) {
            if(file.isDirectory()){ doScanner(scanPackage + "." +  file.getName());}else {
                if(!file.getName().endsWith(".class")){continue;}
                String clazzName = (scanPackage + "." + file.getName().replace(".class",""));
                registyBeanClasses.add(clazzName);
            }
        }
    }

    public Properties getConfig(){
        return this.config;
    }

    //把配置文件中扫描到的所有配置信息转化为GPBeanDefinition，方便之后IOC操作方便
    public List<GPBeanDefinition> loadBeanDefinitions(String... locations) {
        List<GPBeanDefinition> result = new ArrayList<GPBeanDefinition>();
        try {
            for (String className : registyBeanClasses) {
                Class<?> beanClass = Class.forName(className);
                //如果是一个接口，是不能实例化的
                //用它实现类来实例化
                if(beanClass.isInterface()) { continue; }

                //beanName有三种情况:
                //1、默认是类名首字母小写
                //2、自定义名字
                //3、接口注入
                result.add(doCreateBeanDefinition(toLowerFirstCase(beanClass.getSimpleName()),beanClass.getName()));
                //result.add(doCreateBeanDefinition(beanClass.getName(),beanClass.getName()));

                Class<?> [] interfaces = beanClass.getInterfaces();
                for (Class<?> i : interfaces) {
                    //如果是多个实现类，只能覆盖
                    //为什么？因为Spring没那么智能，就是这么傻
                    //这个时候，可以自定义名字
                    result.add(doCreateBeanDefinition(i.getName(),beanClass.getName()));
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    //把每一个配置信息解析成一个BeanDefinition
    //把每一个配信息解析成一个BeanDefinition
    private GPBeanDefinition doCreateBeanDefinition(String factoryBeanName,String beanClassName){
        GPBeanDefinition beanDefinition = new GPBeanDefinition();
        beanDefinition.setBeanClassName(beanClassName);
        beanDefinition.setFactoryBeanName(factoryBeanName);
        return beanDefinition;
    }



    //如果雷鸣本身是小写字母，确实会出问题
    //但是这个方法自己用
    //传值也是自己传，类都遵循了驼峰命名法
    //默认传入的值，不存在字母小写的情况，也不存在非字母的情况
    private String toLowerFirstCase(String simpleName){
        char[] chars = simpleName.toCharArray();
        //之所以加，是因为大写字母ASCII吗相差32
        //而且大写字母的ASCII码小于小写字母
        //在java中，对char做数学运算，实际上就是ASCII码做数学运算
        chars[0] += 32;
        return String.valueOf(chars);

    }
}
