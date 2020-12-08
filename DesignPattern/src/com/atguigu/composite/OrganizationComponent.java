package com.atguigu.composite;

/**
 *
 *
 *@description: 定义一些相关的方法
 * 可以是抽象方法，具体方法，或者是结构
 *@author: 徐小康
 *@time: 2020/12/8 13:26
 * 
 */
public abstract class OrganizationComponent {

    private String name; //名字
    private String des; // 说明


    protected void add(OrganizationComponent organizationComponent) {

    }

    protected void remove(OrganizationComponent organizationComponent){

    }

    protected void print(OrganizationComponent organizationComponent){

    }
}
