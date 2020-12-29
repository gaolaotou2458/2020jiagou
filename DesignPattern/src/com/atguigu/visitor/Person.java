package com.atguigu.visitor;

/**
 *@description: 
 *@author: 徐小康
 *@time: 2020/12/18 9:51
 */
public abstract class Person {

    //提供一个方法，让访问者可以访问
    public abstract  void accept(Action action);
}
