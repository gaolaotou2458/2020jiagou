package com.atguigu.visitor;

/**
 *@description: 
 *@author: ��С��
 *@time: 2020/12/18 9:57
 */
public class Fail extends Action {
    @Override
    public void getNanResult(Man man) {
        System.out.println("���˸��������Ǹø��ֺ�ʧ�ܣ�");
    }

    @Override
    public void getWomenResult(Women women) {
        System.out.println("Ů�˸��������Ǹø��ֺ�ʧ�ܣ�");
    }
}
