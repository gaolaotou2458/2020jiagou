package com.atguigu.observer.improve;

/**
 *@description: 
 *@author: ��С��
 *@time: 2020/12/22 10:10
 */
public class Client {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        
        //�����۲���
        CurrentConditions currentConditions = new CurrentConditions();
        BaiduSite baiduSite = new BaiduSite();
        //ע��
        weatherData.registerObserver(currentConditions);
        weatherData.registerObserver(baiduSite);
        //����
       // System.out.println("֪ͨ����ע��Ĺ۲���");
        //weatherData.setData(30f, 20f, 10f);



        weatherData.setData(230f, 20f, 10f);
    }
}
