package com.atguigu.visitor;

/**
 *@description: 
 *@author: ��С��
 *@time: 2020/12/18 9:55
 */
public class Success extends  Action{
    @Override
    public void getNanResult(Man man) {
        System.out.println("���˸��������Ǹø��ֺܳɹ���");
    }

    @Override
    public void getWomenResult(Women women) {
        System.out.println(" Ů�˸������۸ø��ֺܳɹ���");
    }
}
