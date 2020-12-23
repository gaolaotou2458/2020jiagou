package com.atguigu.observer.improve;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *@description: 核心类，
 * 1 包含最新的天气信息
 * 2.含有观察者集合，使用ArrayList
 *@author: 徐小康
 *@time: 2020/12/22 9:30
 */
public class WeatherData implements  Subject{
    // 温度，气压，湿度
    private float temperatrue;
    private float pressure;
    private float humidity;
    //观察者集合
    private ArrayList<Observer> observers;



    public WeatherData(){
        observers = new ArrayList<>();
    }

    public void dataChange(){
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if(observers.contains(observer)) observers.remove(observer);
    }

    // 遍历所有的观察者并通知
    @Override
    public void notifyObservers() {
        observers.forEach(observer -> {
            observer.update(this.temperatrue,this.pressure,this.humidity);
        });
    }

    //当数据有更新时，就调用 setData
    public void setData(float temperature, float pressure, float humidity) {
        this.temperatrue = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        dataChange();

    }


    public float getTemperatrue() {
        return temperatrue;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }
}
