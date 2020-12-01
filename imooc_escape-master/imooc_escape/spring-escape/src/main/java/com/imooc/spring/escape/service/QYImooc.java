package com.imooc.spring.escape.service;

import org.springframework.stereotype.Service;

/**
 * <h1>Spring Bean 的默认名称生成策略</h1>
 * 默认是首字母小写
 * 特殊情况： 首字母
 * AnnotationBeanNameGenerator 源码分析：长度大于1，第一个字母和第二个字母都是大写，直接返回当前名称
 * if (name.length() > 1 && Character.isUpperCase(name.charAt(1)) &&
 *                         Character.isUpperCase(name.charAt(0))){
 *             return name;
 *         }
 * */
@Service("qYImooc")
//@Service
public class QYImooc {

    public void print() {
        System.out.println("QYImooc");
    }
}
