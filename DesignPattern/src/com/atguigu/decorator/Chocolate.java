package com.atguigu.decorator;

/**
 *
 *
 *@description: ����ĵ�ζƷ���ɿ���
 *@author: ��С��
 *@time: 2020/12/7 11:03
 * 
 */
public class Chocolate extends Decorator{
    public Chocolate(Drink drink) {
        super(drink);
        setDes(" �ɿ��� ");
        setPrice(3.0f);  //��ζƷ�ļ۸�
    }
}
