package com.gupaoedu.vip.spring.formework.aop.interpect;

/**
 * Created by Tom on 2019/4/14.
 */
public interface GPMethodInterceptor {
    Object invoke(GPMethodInvocation invocation) throws Throwable;
}
