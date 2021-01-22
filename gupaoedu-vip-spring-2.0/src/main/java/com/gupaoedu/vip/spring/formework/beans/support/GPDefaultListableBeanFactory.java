package com.gupaoedu.vip.spring.formework.beans.support;

import com.gupaoedu.vip.spring.formework.beans.config.GPBeanDefinition;
import com.gupaoedu.vip.spring.formework.context.support.GPAbstractApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: GPDefaultListableBeanFactory
 * @Description: 默认容器实现
 * @Author: xuxk
 * @Date: 2021-01-18 09:40
 * @Version: 1.0
 **/
public class GPDefaultListableBeanFactory extends GPAbstractApplicationContext {

    //存储注册信息的BeanDefinition
    protected final Map<String, GPBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);
}
