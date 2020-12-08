package com.atguigu.composite;

/**
 *
 *
 *@description: 系-叶子节点
 *@author: 徐小康
 *@time: 2020/12/8 13:27
 * 
 */
public class Department extends OrganizationComponent{

    //没有聚合

    public Department(String name, String des) {
        super(name, des);
    }



    // add , remove 就不用写了，因为他是叶子节点


    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    @Override
    protected void print() {
        System.out.println("  |--" +getName());
    }
}
