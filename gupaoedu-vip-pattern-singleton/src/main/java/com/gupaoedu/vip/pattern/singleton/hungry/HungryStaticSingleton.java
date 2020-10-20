package com.gupaoedu.vip.pattern.singleton.hungry;

/**
 * Created by Tom.
 */

//饿汉式静态块单例
public class HungryStaticSingleton {
    //不加final 可能有人通过反射修改
    private static final HungryStaticSingleton hungrySingleton;
    static {
        hungrySingleton = new HungryStaticSingleton();
    }
    private HungryStaticSingleton(){}
    public static HungryStaticSingleton getInstance(){
        return  hungrySingleton;
    }
}
