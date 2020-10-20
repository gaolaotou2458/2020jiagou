package com.gupaoedu.vip.pattern.singleton.threadlocal;

/**
 * Created by Tom.
 */

/**
 * 在线程内，线程安全，是同一个对象
 * 不同线程是不同的对象
 * 使用ThreadLocal来实现多数据源动态切换
 */
//伪线程安全
public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance =
            new ThreadLocal<ThreadLocalSingleton>(){

                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };

    private ThreadLocalSingleton(){}

    public static ThreadLocalSingleton getInstance(){
        return threadLocalInstance.get();
    }
}
