package com.atguigu.decorator;

/**
 *
 *
 *@description: ����ĵ�ζƷ������
 *@author: ��С��
 *@time: 2020/12/7 11:03
 * 
 */
public class Soy extends Decorator{
    public Soy(Drink drink) {
        super(drink);
        setDes(" ���� ");
        setPrice(1.5f);  //��ζƷ�ļ۸�
    }
}
