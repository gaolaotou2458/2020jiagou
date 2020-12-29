package com.atguigu.visitor;

/**
 *@description: 
 *@author: 徐小康
 *@time: 2020/12/18 9:48
 */
public abstract class Action {
    // 得到男性的测评
    public abstract void getNanResult(Man man);

    //得到女的 测评
    public abstract void getWomenResult(Women women);
}
