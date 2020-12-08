package com.atguigu.decorator;

/**
 *
 *
 *@description: 模拟装饰者模式下订单
 *@author: 徐小康
 *@time: 2020/12/7 11:06
 * 
 */
public class CoffeeBar {

    public static void main(String[] args) {
        //2分巧克力+一份牛奶的LongBlackCoffee
        Drink order = new LongBlackCoffee();
        System.out.println("费用1=" + order.cost());
        System.out.println("描述=" + order.getDes());

        //2.加入一份牛奶
        order = new Milk(order);
        System.out.println("order 加入一份牛奶，费用=" + order.cost());
        System.out.println("order 加入一份牛奶，描述=" + order.getDes());

        //3.加入一份巧克力
        order = new Chocolate(order);
        System.out.println("order 加入一份巧克力，又加入巧克力，费用=" + order.cost());
        System.out.println("order 加入一份牛奶，又加入巧克力，描述=" + order.getDes());
    }
}
