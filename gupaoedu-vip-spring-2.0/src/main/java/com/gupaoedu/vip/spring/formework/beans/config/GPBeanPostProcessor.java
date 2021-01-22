package com.gupaoedu.vip.spring.formework.beans.config;

/**
 * @ClassName: GPBeanPostProcessor
 * @Description: AOP
 * @Author: xuxk
 * @Date: 2021-01-22 09:53
 * @Version: 1.0
 **/
public class GPBeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

}
