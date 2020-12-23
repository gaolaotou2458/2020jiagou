package com.atguigu.observer.improve;

/**
 *@description: 观察者
 * 由观察者来实现
 *@author: 徐小康
 *@time: 2020/12/22 9:28
 */
public interface Observer {
    //温度 气压 湿度
    public void update(float temperatrue,float pressure, float humidity);


}
