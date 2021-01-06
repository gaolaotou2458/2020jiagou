package com.gupaoedu.mvcframework.v2.servlet;

import com.gupaoedu.mvcframework.annotation.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;


/**
 * Created by Tom.
 */
public class GPDispatcherServlet extends HttpServlet{

    //保存application.properties配置文件中的内容
    private Properties contextConfig = new Properties();

    //保存所有扫描到的类名
    private List<String> classNames = new ArrayList<>();

    //IOC容器,我们来揭开神秘面纱
    //为了简化程序，暂时不考虑ConcurrentHashMap
    private Map<String,Object> ioc = new HashMap<String,Object>();

    //存放url 和method的容器
    private Map<String,Method> handlerMapping = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 6、调用，运行阶段
        try {
            doDispatch(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("500 Exception,Detail:" + Arrays.toString(e.getStackTrace()));
        }
    }

//    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//        //绝对路径
//        String url = req.getRequestURI();
//        //处理成相对路径
//        String contextPath = req.getContextPath();
//        url.replaceAll(contextPath,"").replaceAll("/+","/");
//
//        if(!this.handlerMapping.containsKey(url)) {
//            resp.getWriter().write("404 Not Found！！！！");
//            return;
//        }
//
//        Method method = this.handlerMapping.get(url);
//        //通过投机取巧
//        //通过反射获取method所在的clazz,拿到clazz之后拿到class的名称
//        //再调用toLowerFirstCase获取beanName
//        String beanName = toLowerFirstCase(method.getDeclaringClass().getSimpleName());
//
//        //为了投机取巧，暂时写死
//        Map<String, String[]> params = req.getParameterMap();
//        method.invoke(ioc.get(beanName),new Object[]{req,resp,params.get("name")[0]});
//
//    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp)throws Exception {
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replaceAll(contextPath,"").replaceAll("/+","/");
        if(!this.handlerMapping.containsKey(url)){
            resp.getWriter().write("404 Not Found!!");
            return;
        }

        Method method = this.handlerMapping.get(url);
        //第一个参数：方法所在的实例
        //第二个参数：调用时所需要的实参
        Map<String,String[]> params = req.getParameterMap();
        //获取方法的形参列表
        Class<?> [] parameterTypes = method.getParameterTypes();
        //保存请求的url参数列表
        Map<String,String[]> parameterMap = req.getParameterMap();
        //保存赋值参数的位置
        Object [] paramValues = new Object[parameterTypes.length];
        //按根据参数位置动态赋值
        for (int i = 0; i < parameterTypes.length; i ++){
            Class parameterType = parameterTypes[i];
            if(parameterType == HttpServletRequest.class){
                paramValues[i] = req;
                continue;
            }else if(parameterType == HttpServletResponse.class){
                paramValues[i] = resp;
                continue;
            }else if(parameterType == String.class){
                //提取方法中加了注解的参数
                //把方法上的注解拿到，得到的是一个二维数组
                //因为一个参数可以有多个注解，而一个方法又有多个参数
                Annotation [] [] pa = method.getParameterAnnotations();
                for (int j = 0; j < pa.length ; j ++) {
                    for(Annotation a : pa[j]){
                        if(a instanceof GPRequestParam){
                            String paramName = ((GPRequestParam) a).value();
                            if(params.containsKey(paramName)) {
                                for (Map.Entry<String,String[]> param : parameterMap.entrySet()){
                                    String value = Arrays.toString(param.getValue())
                                            .replaceAll("\\[|\\]","")
                                            .replaceAll("\\s",",");
                                    paramValues[i] = value;
                                }
                            }
                        }
                    }
                }
            }
        }
        //投机取巧的方式
        String beanName = toLowerFirstCase(method.getDeclaringClass().getSimpleName());
        method.invoke(ioc.get(beanName),paramValues);
    }

    //初始化阶段
    @Override
    public void init(ServletConfig config) throws ServletException {
        //1、加载配置文件
            //从web.xml找到配置文件Key
        doLoadConfig(config.getInitParameter("contextConfigLocation"));

        //2、扫描相关的类 application.properties
        doScanner(contextConfig.getProperty("scanPackage"));

        //3、初始化扫描到的类，并且将他们放入到IOC容器中
        doInstance();

        //4、完成依赖注入
        doAutowired();

        //5、初始化HandlerMapping
        initHandlerMapping();

        System.out.println("个人 Spring framework 初始化完成");

    }

    private void doLoadConfig(String contextConfigLocation) {
        // 直接从类路径下载到Spring主配置文件所在的路径
        // 并且将其读取出来放到Properties对象中
        //
        try (
            InputStream fis = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation)
        ) {
            contextConfig.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //扫描出相关的类
    private void doScanner(String scanpackage) {
        //scanPackage = com.gupaodu.demo,存储的是包路径
        //转化为文件路径，实际上就是把，替换为/就OK
        //classpath
        URL url = this.getClass().getClassLoader().getResource("/" + scanpackage.replaceAll("\\.","/"));
        File classPath = new File(url.getFile());
        for (File file : classPath.listFiles()) {
            //文件夹则递归取
            if(file.isDirectory()) {
                doScanner(scanpackage + "." +file.getName());
            } else {
                if(!file.getName().endsWith(".class")){continue;}
                String className = scanpackage + "." +file.getName().replace(".class","");
                classNames.add(className);

            }
        }
    }

    private void doInstance(){
        //初始化，为DI做准备
        if(classNames.isEmpty()) return;
        try {
            for(String className : classNames) {

                Class<?> clazz = Class.forName(className);
                //什么样子的类需要初始化？
                //加了注解的类，才初始化，怎么判断
                if(clazz.isAnnotationPresent(GPController.class)) {
                    Object instance = clazz.getDeclaredConstructor().newInstance();
                    //key className首字母小写
                    String beanName = toLowerFirstCase(clazz.getSimpleName());
                    ioc.put(beanName,instance);
                } else if(clazz.isAnnotationPresent(GPService.class)){
                    //注解里面 service("aaService")
                    //1、默认类名首字母小写
                    GPService service = clazz.getAnnotation(GPService.class);
                    String beanName = toLowerFirstCase(clazz.getSimpleName());
                    //2、自定义的beanName
                    if("".equals(beanName)){
                        beanName =service.value();
                    }
                    Object instance = clazz.getDeclaredConstructor().newInstance();
                    ioc.put(beanName,instance);
                    //3、根据类型自动赋值,需要实例化接口实现类
                    for(Class<?> i : clazz.getInterfaces()){
                        if(ioc.containsKey(i.getName())) {
                            throw new Exception("这个" + i.getName() + "已经存在！不能重复");
                        }
                        ioc.put(i.getName(),instance);
                    }
                } else {
                    continue;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void doAutowired(){
        if(ioc.isEmpty()) return;
        ioc.entrySet().forEach(map -> {
            //Declared 所有的，反射包括private
            //正常来说，普通的OOP编程只能拿到Public的属性
            Field[] fields = map.getValue().getClass().getDeclaredFields();
            for (Field field : fields) {
                //没有这个注解直接跳过
                if(!field.isAnnotationPresent(GPAutowired.class)) continue;
                GPAutowired autowired = field.getAnnotation(GPAutowired.class);
                // 如果用户没有自定义beanName,默认就根据类型注入
                // 这个地方省去了对类名首字母小写情况的判断，
                // 小伙伴自己实现
                String beanName = autowired.value().trim();
                if("".equals(beanName)) {
                    //获得接口的类型，作为key待会拿这个key到ioc容器取值
                    beanName = field.getType().getName();
                }
                //利用反射动态赋值
                //保证私有修饰符也能获取
                field.setAccessible(true);
                try {
                    field.set(map.getValue(),ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        });
    }



    //初始化url和method 一对一的对应关系
    private void initHandlerMapping(){
        if(ioc.isEmpty()) return;
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            if(!clazz.isAnnotationPresent(GPController.class)) continue;
            // 保存写在类上面的Url
            String baseUrl = "";
            if(clazz.isAnnotationPresent(GPRequestMapping.class)){
                GPRequestMapping requestMapping = clazz.getAnnotation(GPRequestMapping.class);
                baseUrl = requestMapping.value();
            }

            //默认获取所有的Public方法
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if(!method.isAnnotationPresent(GPRequestMapping.class))continue;
                GPRequestMapping requestMapping = method.getAnnotation(GPRequestMapping.class);
                //类url + 方法url构建成完整的url  替换// ->/ 防止出现多个/
                String url = (baseUrl + "/" +requestMapping.value()).replaceAll("/+","/");
                handlerMapping.put(url,method);
                System.out.println("映射：" + url + "方法：" + method);
            }
        }


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
