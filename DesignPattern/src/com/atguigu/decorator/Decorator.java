package com.atguigu.decorator;

/**
 *
 *
 *@description: װ����
 *@author: ��С��
 *@time: 2020/12/7 10:56
 * 
 */
public class Decorator extends Drink {

    //�����ı�װ����
    private Drink drink;

    //���
    public Decorator(Drink drink) {
        this.drink = drink;
    }

    //�ݹ�������
    @Override
    public float cost() {
        // super.getPrice() �Լ��ļ۸�
        return super.getPrice() + drink.cost();
    }

    @Override
    public String getDes() {
        //drink.getDes() �����װ���ߵ���Ϣ
        return super.des + "" + super.getPrice() + " &&" + drink.getDes();
    }
}
