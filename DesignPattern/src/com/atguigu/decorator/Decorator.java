package com.atguigu.decorator;

/**
 *
 *
 *@description: 装饰者
 *@author: 徐小康
 *@time: 2020/12/7 10:56
 * 
 */
public class Decorator extends Drink {

    //真正的被装饰者
    private Drink drink;

    //组合
    public Decorator(Drink drink) {
        this.drink = drink;
    }

    //递归计算费用
    @Override
    public float cost() {
        // super.getPrice() 自己的价格
        return super.getPrice() + drink.cost();
    }

    @Override
    public String getDes() {
        //drink.getDes() 输出呗装饰者的信息
        return super.des + "" + super.getPrice() + " &&" + drink.getDes();
    }
}
