package com.atguigu.visitor;

/**
 *@description: 
 *@author: 徐小康
 *@time: 2020/12/18 9:51
 * 说明：
 * 1.这里使用了双分派，首先在客户端程序中，讲具体状态作为参数船体Woman中（第一次分派）
 * 2。然后Woman类调用作为参数的“具体方法”中getWomenResult，同时将自己（this）作为参数
 * 传递，完成二次分派
 */
public class Women extends Person {
    @Override
    public void accept(Action action) {
        action.getWomenResult(this);
    }
}
