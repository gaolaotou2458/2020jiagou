package com.atguigu.visitor;

/**
 *@description: 
 *@author: ��С��
 *@time: 2020/12/18 9:48
 */
public abstract class Action {
    // �õ����ԵĲ���
    public abstract void getNanResult(Man man);

    //�õ�Ů�� ����
    public abstract void getWomenResult(Women women);
}
