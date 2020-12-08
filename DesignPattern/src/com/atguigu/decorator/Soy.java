package com.atguigu.decorator;

/**
 *
 *
 *@description: 具体的调味品，豆浆
 *@author: 徐小康
 *@time: 2020/12/7 11:03
 * 
 */
public class Soy extends Decorator{
    public Soy(Drink drink) {
        super(drink);
        setDes(" 豆浆 ");
        setPrice(1.5f);  //调味品的价格
    }
}
