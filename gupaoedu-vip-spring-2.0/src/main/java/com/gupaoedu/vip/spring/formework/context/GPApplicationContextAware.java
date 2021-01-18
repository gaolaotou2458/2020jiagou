package com.gupaoedu.vip.spring.formework.context;

/**
 * @ClassName: GPApplicationContextAware
 * @Description: 一个通过解耦的方式获得IOC容器的顶层设计
 * @Author: xuxk
 * @Date: 2021-01-18 10:21
 * @Version: 1.0
 **/
public interface GPApplicationContextAware {

    void setApplicationContext(GPApplicationContext GPapplicationContext) throws BeansException;

}
