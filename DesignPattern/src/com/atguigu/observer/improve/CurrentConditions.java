package com.atguigu.observer.improve;

/**
 *@description: ʵ�ʹ۲���
 *@author: ��С��
 *@time: 2020/12/22 9:37
 */
public class CurrentConditions implements Observer{
    // �¶ȣ���ѹ��ʪ��
    private float temperature;
    private float pressure;
    private float humidity;

    //���� ������������� WeatherData �����ã���ʹ������ģʽ
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    //��ʾ
    public void display() {
        System.out.println("***Today �¶�: " + temperature + "***");
        System.out.println("***Today ��ѹ: " + pressure + "***");
        System.out.println("***Today ʪ��: " + humidity + "***");
    }
}
