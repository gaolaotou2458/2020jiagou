package com.atguigu.builder;

/**
 *
 *
 *@description: 
 *@author: ��С��
 *@time: 2020/12/1 15:06
 * 
 */
public class BieShuHouse extends AbstractHouse{
    @Override
    public void buildBasic() {
        System.out.println("�����ػ�");
    }

    @Override
    public void buildWalls() {
        System.out.println("����ˢǽ");
    }

    @Override
    public void roofed() {
        System.out.println("�����ⶥ");
    }


}
