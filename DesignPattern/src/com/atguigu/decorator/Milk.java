package com.atguigu.decorator;

/**
 *
 *
 *@description: ����ĵ�ζƷ��ţ��
 *@author: ��С��
 *@time: 2020/12/7 11:03
 * 
 */
public class Milk extends Decorator{
    public Milk(Drink drink) {
        super(drink);
        setDes(" ţ�� ");
        setPrice(2.0f);  //��ζƷ�ļ۸�
    }
}
