package com.imooc.spring.escape.cyclic_dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
//原型模式出现循环依赖问题
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class QinyiJavaService {

//    private final ImoocCourseService courseService;
//
//    @Autowired
//    public QinyiJavaService(ImoocCourseService courseService) {
//        this.courseService = courseService;
//    }

    //属性注入方式，spring自己解决循环依赖问题
    // Field
    @Autowired
    private ImoocCourseService courseService;

    public void qinyiJava() {
        //courseService.imoocCourse();
        System.out.println("QinyiJavaService");
    }
}
