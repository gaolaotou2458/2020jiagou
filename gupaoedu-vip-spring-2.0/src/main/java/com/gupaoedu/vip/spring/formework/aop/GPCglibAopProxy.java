package com.gupaoedu.vip.spring.formework.aop;

import com.gupaoedu.vip.spring.formework.aop.support.GPAdvisedSupport;

/**
 * @ClassName: CglibAopProxy
 * @Description:
 * @Author: xuxk
 * @Date: 2021-01-26 13:21
 * @Version: 1.0
 **/
public class GPCglibAopProxy implements GPAopProxy{

    private GPAdvisedSupport advised;

    @Override
    public Object getProxy() {
        return null;
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        return null;
    }

    public GPCglibAopProxy(GPAdvisedSupport config) {
        this.advised = config;
    }
}
