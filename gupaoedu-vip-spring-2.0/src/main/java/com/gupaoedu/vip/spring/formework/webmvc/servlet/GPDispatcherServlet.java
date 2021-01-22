package com.gupaoedu.vip.spring.formework.webmvc.servlet;

import com.gupaoedu.vip.spring.formework.annotation.GPController;
import com.gupaoedu.vip.spring.formework.annotation.GPRequestMapping;
import com.gupaoedu.vip.spring.formework.context.GPApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: GPDispatcherServlet
 * @Description: mvc开始的地方
 * @Author: xuxk
 * @Date: 2021-01-22 10:53
 * @Version: 1.0
 **/
public class GPDispatcherServlet extends HttpServlet {

    private final String CONTEXT_CONFIG_LOCATION = "contextConfigLocation";

    private GPApplicationContext context;

    //思考：为什么不用Map
    //你用Map的话，key，只能是url
    //Handler 本身的功能就是把url和method对应关系，已经具备了Map的功能
    //根据设计原则：冗余的感觉了，单一职责，最少知道原则，帮助我们更好的理解
    private List<GPHandlerMapping> handlerMappings = new ArrayList<GPHandlerMapping>();

    private Map<GPHandlerMapping,GPHandlerAdapter> handlerAdapters = new HashMap<GPHandlerMapping,GPHandlerAdapter>();

    private List<GPViewResolver> viewResolvers = new ArrayList<GPViewResolver>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            this.doDispatcher(req,resp);
        }catch(Exception e){
            resp.getWriter().write("500 Exception,Details:\r\n" + Arrays.toString(e.getStackTrace()).replaceAll("\\[|\\]", "").replaceAll(",\\s", "\r\n"));
            e.printStackTrace();
//            new GPModelAndView("500");

        }
    }

    //初始化策略
    protected void initStrategies(GPApplicationContext context) {
        //多文件上传的组件
        initMultipartResolver(context);
        //初始化本地语言环境
        initLocaleResolver(context);
        //初始化模板处理器
        initThemeResolver(context);


        //handlerMapping，必须实现
        initHandlerMappings(context);
        //初始化参数适配器，必须实现
        initHandlerAdapters(context);
        //初始化异常拦截器
        initHandlerExceptionResolvers(context);
        //初始化视图预处理器
        initRequestToViewNameTranslator(context);


        //初始化视图转换器，必须实现
        initViewResolvers(context);
        //参数缓存器
        initFlashMapManager(context);
    }

    private void doDispatcher(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1、通过从request中拿到URL，去匹配一个HandlerMapping
        GPHandlerMapping handler = getHandler(req);

        if(handler == null){
            processDispatchResult(req,resp,new GPModelAndView("404"));
            return;
        }

        //2、准备调用前的参数
        GPHandlerAdapter ha = getHandlerAdapter(handler);

        //3、真正的调用方法,返回ModelAndView存储了要穿页面上值，和页面模板的名称
        GPModelAndView mv = ha.handle(req,resp,handler);

        //这一步才是真正的输出
        processDispatchResult(req, resp, mv);
    }

    private void processDispatchResult(HttpServletRequest req, HttpServletResponse resp, GPModelAndView mv) throws Exception{
        //把给我的ModleAndView变成一个HTML、OuputStream、json、freemark、veolcity
        //ContextType
        if(null == mv){return;}

        //如果ModelAndView不为null，怎么办？
        if(this.viewResolvers.isEmpty()){return;}

        for (GPViewResolver viewResolver : this.viewResolvers) {
            GPView view = viewResolver.resolveViewName(mv.getViewName(),null);
            view.render(mv.getModel(),req,resp);
            return;
        }


    }

    private GPHandlerAdapter getHandlerAdapter(GPHandlerMapping handler) {
        if(this.handlerAdapters.isEmpty()){return null;}
        GPHandlerAdapter ha = this.handlerAdapters.get(handler);
        if(ha.supports(handler)){
            return ha;
        }
        return null;
    }


    @Override
    public void init(ServletConfig config) throws ServletException {
        // 1 初始化ApplicationContext
        context = new GPApplicationContext(config.getInitParameter(CONTEXT_CONFIG_LOCATION));
        initStrategies(context);
        // 2 初始化  MVC 九大组件

    }



    private void initFlashMapManager(GPApplicationContext context) {
    }

    private void initViewResolvers(GPApplicationContext context) {
        // 拿到末班的存放目录
        String templateRoot = context.getConfig().getProperty("templateRoot");
        String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();

        File templateRootDir = new File(templateRootPath);

        for (File template : templateRootDir.listFiles()) {
            this.viewResolvers.add(new GPViewResolver(templateRoot));
        }

    }

    private void initRequestToViewNameTranslator(GPApplicationContext context) {
    }

    private void initHandlerExceptionResolvers(GPApplicationContext context) {
    }

    private void initHandlerAdapters(GPApplicationContext context) {
        // 吧一个request请求变成一个handler，参数全部是字符串，自动匹配到handler中的形参

        // 可想而知，他要拿到HandlerMapping 才能干活

        //就意味着，有几个HandlerMapping就有几个HadnlerAdapter
        for (GPHandlerMapping handlerMapping : this.handlerMappings) {
            this.handlerAdapters.put(handlerMapping,new GPHandlerAdapter());
        }
    }

    private void initHandlerMappings(GPApplicationContext context) {
        String[] beanNames = context.getBeanDefinitionNames();
        try {
            for (String beanName : beanNames) {
                Object controller = context.getBean(beanName);
                Class<?> clazz = controller.getClass();
                if(!clazz.isAnnotationPresent(GPController.class)){continue;}


                //保存写在类上面的@GPRequestMapping("/demo")
                String baseUrl = "";
                if(clazz.isAnnotationPresent(GPRequestMapping.class)){
                    GPRequestMapping requestMapping = clazz.getAnnotation(GPRequestMapping.class);
                    baseUrl = requestMapping.value();
                }

                //默认获取所有的public方法
                for (Method method : clazz.getMethods()) {
                    if(!method.isAnnotationPresent(GPRequestMapping.class)){continue;}

                    GPRequestMapping requestMapping = method.getAnnotation(GPRequestMapping.class);
                    //优化
                    // //demo///query
                    String regex = ("/" + baseUrl + "/" + requestMapping.value().replaceAll("\\*",".*"))
                            .replaceAll("/+","/");
                    Pattern pattern = Pattern.compile(regex);
                    this.handlerMappings.add(new GPHandlerMapping(pattern,controller,method));
//                handlerMapping.put(url,method);
                    System.out.println("Mapped :" + pattern + "," + method);

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initThemeResolver(GPApplicationContext context) {
    }

    private void initLocaleResolver(GPApplicationContext context) {
    }

    private void initMultipartResolver(GPApplicationContext context) {
    }

    private GPHandlerMapping getHandler(HttpServletRequest req) {
        if(this.handlerMappings.isEmpty()){return null;}
        //绝对路径
        String url = req.getRequestURI();
        //处理成相对路径
        String contextPath = req.getContextPath();
        url = url.replaceAll(contextPath,"").replaceAll("/+","/");


        for (GPHandlerMapping handler : this.handlerMappings) {
            Matcher matcher = handler.getPattern().matcher(url);
            if(!matcher.matches()){ continue;}
            return handler;
        }
        return null;
    }
}
