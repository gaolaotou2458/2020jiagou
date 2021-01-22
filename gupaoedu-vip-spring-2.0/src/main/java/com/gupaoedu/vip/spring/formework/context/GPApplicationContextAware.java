package com.gupaoedu.vip.spring.formework.context;

/**
 * @ClassName: GPApplicationContextAware
 * @Description: 一个通过解耦的方式获得IOC容器的顶层设计
 * 后面通过一个监听器去扫描所有的类setApplicationContext方法
 * 从而将IOC容器注入到目标类中
 * 只要实现了此接口，将自动调用
 * @Author: xuxk
 * @Date: 2021-01-18 10:21
 * @Version: 1.0
 **/
public interface GPApplicationContextAware {

    void setApplicationContext(GPApplicationContext GPapplicationContext);

}
