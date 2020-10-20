package com.gupaoedu.vip.pattern.singleton.register;

/**
 * Created by Tom.
 */
//常量中去使用，常量不就是用来大家都能够共用吗？
//通常在通用API中使用
public enum EnumSingleton {
    //上面的EnumSingleton的定义利用的enum是一种特殊的class.代码中的第一行INSTANCE会被编译器编译为SingletonEnum本身的一个对象.
    // 当第一次访问EnumSingleton.INSTANCE时会创建该对象,并且enum变量的创建是线程安全的.
    INSTANCE;
    private Object data;
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
