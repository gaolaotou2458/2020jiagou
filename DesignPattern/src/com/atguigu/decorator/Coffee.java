package com.atguigu.decorator;

/**
 *
 *
 *@description: 
 *@author: ��С��
 *@time: 2020/12/7 10:52
 * 
 */
public class Coffee extends Drink {

    @Override
    public float cost() {
        return super.getPrice();
    }
}
