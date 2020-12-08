package com.atguigu.decorator;

/**
 *
 *
 *@description: 具体的调味品，牛奶
 *@author: 徐小康
 *@time: 2020/12/7 11:03
 * 
 */
public class Milk extends Decorator{
    public Milk(Drink drink) {
        super(drink);
        setDes(" 牛奶 ");
        setPrice(2.0f);  //调味品的价格
    }
}
