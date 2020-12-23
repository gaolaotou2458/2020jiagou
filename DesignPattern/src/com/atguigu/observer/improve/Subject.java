package com.atguigu.observer.improve;


/**
 *@description: 类似气象站
 *@author: 徐小康
 *@time: 2020/12/22 9:25
 */
public interface Subject {

    //注册
    void registerObserver(Observer observer);

    //移除
    void removeObserver(Observer observer);

    //关注
    void notifyObservers();
}
