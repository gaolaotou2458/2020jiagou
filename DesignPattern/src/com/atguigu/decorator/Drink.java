package com.atguigu.decorator;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;

/**
 *
 *
 *@description: 
 *@author: ��С��
 *@time: 2020/12/7 10:40
 * 
 */
public abstract class Drink {

    public String des; //����
    private float price = 0.0f;


    //������õĳ��󷽷�
    public abstract  float cost();

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
