package com.atguigu.observer.improve;

/**
 *@description: 
 *@author: 徐小康
 *@time: 2020/12/22 10:10
 */
public class Client {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        
        //创建观察者
        CurrentConditions currentConditions = new CurrentConditions();
        BaiduSite baiduSite = new BaiduSite();
        //注册
        weatherData.registerObserver(currentConditions);
        weatherData.registerObserver(baiduSite);
        //测试
       // System.out.println("通知各个注册的观察者");
        //weatherData.setData(30f, 20f, 10f);



        weatherData.setData(230f, 20f, 10f);
    }
}
