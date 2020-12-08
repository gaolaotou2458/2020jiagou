package com.atguigu.decorator;

/**
 *
 *
 *@description: ģ��װ����ģʽ�¶���
 *@author: ��С��
 *@time: 2020/12/7 11:06
 * 
 */
public class CoffeeBar {

    public static void main(String[] args) {
        //2���ɿ���+һ��ţ�̵�LongBlackCoffee
        Drink order = new LongBlackCoffee();
        System.out.println("����1=" + order.cost());
        System.out.println("����=" + order.getDes());

        //2.����һ��ţ��
        order = new Milk(order);
        System.out.println("order ����һ��ţ�̣�����=" + order.cost());
        System.out.println("order ����һ��ţ�̣�����=" + order.getDes());

        //3.����һ���ɿ���
        order = new Chocolate(order);
        System.out.println("order ����һ���ɿ������ּ����ɿ���������=" + order.cost());
        System.out.println("order ����һ��ţ�̣��ּ����ɿ���������=" + order.getDes());
    }
}
