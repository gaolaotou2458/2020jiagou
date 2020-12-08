package com.atguigu.decorator;

/**
 *
 *
 *@description: 具体的调味品，巧克力
 *@author: 徐小康
 *@time: 2020/12/7 11:03
 * 
 */
public class Chocolate extends Decorator{
    public Chocolate(Drink drink) {
        super(drink);
        setDes(" 巧克力 ");
        setPrice(3.0f);  //调味品的价格
    }
}
