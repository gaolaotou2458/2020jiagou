package com.atguigu.builder;

/**
 *
 *
 *@description: 
 *@author: 徐小康
 *@time: 2020/12/1 15:06
 * 
 */
public class BieShuHouse extends AbstractHouse{
    @Override
    public void buildBasic() {
        System.out.println("别墅地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("别墅刷墙");
    }

    @Override
    public void roofed() {
        System.out.println("别墅封顶");
    }


}
