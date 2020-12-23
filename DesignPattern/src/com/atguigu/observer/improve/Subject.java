package com.atguigu.observer.improve;


/**
 *@description: ��������վ
 *@author: ��С��
 *@time: 2020/12/22 9:25
 */
public interface Subject {

    //ע��
    void registerObserver(Observer observer);

    //�Ƴ�
    void removeObserver(Observer observer);

    //��ע
    void notifyObservers();
}
