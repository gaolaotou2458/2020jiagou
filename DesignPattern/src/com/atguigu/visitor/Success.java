package com.atguigu.visitor;

/**
 *@description: 
 *@author: 徐小康
 *@time: 2020/12/18 9:55
 */
public class Success extends  Action{
    @Override
    public void getNanResult(Man man) {
        System.out.println("男人给的评价是该歌手很成功！");
    }

    @Override
    public void getWomenResult(Women women) {
        System.out.println(" 女人给的评价该歌手很成功！");
    }
}
