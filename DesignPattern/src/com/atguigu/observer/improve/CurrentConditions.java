package com.atguigu.observer.improve;

/**
 *@description: 实际观察者
 *@author: 徐小康
 *@time: 2020/12/22 9:37
 */
public class CurrentConditions implements Observer{
    // 温度，气压，湿度
    private float temperature;
    private float pressure;
    private float humidity;

    //更新 天气情况，是由 WeatherData 来调用，我使用推送模式
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    //显示
    public void display() {
        System.out.println("***Today 温度: " + temperature + "***");
        System.out.println("***Today 气压: " + pressure + "***");
        System.out.println("***Today 湿度: " + humidity + "***");
    }
}
