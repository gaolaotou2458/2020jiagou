package com.atguigu.visitor;

/**
 *@description: 
 *@author: ��С��
 *@time: 2020/12/18 9:48
 */
public class Man extends Person{
    @Override
    public void accept(Action action) {
        action.getNanResult(this);
    }
}
