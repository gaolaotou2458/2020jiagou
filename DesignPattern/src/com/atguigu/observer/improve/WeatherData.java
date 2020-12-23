package com.atguigu.observer.improve;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *@description: �����࣬
 * 1 �������µ�������Ϣ
 * 2.���й۲��߼��ϣ�ʹ��ArrayList
 *@author: ��С��
 *@time: 2020/12/22 9:30
 */
public class WeatherData implements  Subject{
    // �¶ȣ���ѹ��ʪ��
    private float temperatrue;
    private float pressure;
    private float humidity;
    //�۲��߼���
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

    // �������еĹ۲��߲�֪ͨ
    @Override
    public void notifyObservers() {
        observers.forEach(observer -> {
            observer.update(this.temperatrue,this.pressure,this.humidity);
        });
    }

    //�������и���ʱ���͵��� setData
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
