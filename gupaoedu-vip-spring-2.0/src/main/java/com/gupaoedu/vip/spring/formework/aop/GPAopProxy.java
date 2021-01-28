package com.gupaoedu.vip.spring.formework.aop;

/**
 * @ClassName: GPAopProxy
 * @Description:
 * @Author: xuxk
 * @Date: 2021-01-26 13:19
 * @Version: 1.0
 **/
public interface GPAopProxy {
    Object getProxy();

    Object getProxy(ClassLoader classLoader);
}
