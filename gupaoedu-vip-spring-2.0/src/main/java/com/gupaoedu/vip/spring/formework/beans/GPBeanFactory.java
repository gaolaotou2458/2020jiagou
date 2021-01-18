package com.gupaoedu.vip.spring.formework.beans;

/**
 * @ClassName: GPBeanFactory
 * @Description: 规范
 * @Author: xuxk
 * @Date: 2021-01-18 08:45
 * @Version: 1.0
 **/
public interface GPBeanFactory {
    /**
     * 单例的全局访问点
     * 根据beanName从IOC容器中获取一个实例bean
     * @param beanName
     * @return
     */
    Object getBean(String beanName);
}
