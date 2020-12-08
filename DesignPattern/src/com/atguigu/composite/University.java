package com.atguigu.composite;

import java.util.ArrayList;
import java.util.List;

/**
 *@description: 大学
 *@author: 徐小康
 *@time: 2020/12/8 13:27
 */
//University 就是 Composite,可以管理College
public class University extends OrganizationComponent{

    List<OrganizationComponent> organizationComponents = new ArrayList<OrganizationComponent>();

    public University(String name, String des) {
        super(name, des);
    }

    //重写add方法
    @Override
    protected void add(OrganizationComponent organizationComponent) {
        organizationComponents.add(organizationComponent);
    }


    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponents.remove(organizationComponent);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    //print 方法，就是输出University 包含的学院
    @Override
    protected void print() {
        System.out.println(getName());
        //遍历
        organizationComponents.forEach(item -> item.print());

    }
}
