package com.atguigu.composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *@description: 学院-非叶子节点
 *@author: 徐小康
 *@time: 2020/12/8 13:27
 * 
 */
public class College extends OrganizationComponent{

    //这个List存放的是Department
    List<OrganizationComponent> organizationComponents = new ArrayList<OrganizationComponent>();

    public College(String name, String des) {
        super(name, des);
    }



    //重写add方法
    @Override
    protected void add(OrganizationComponent organizationComponent) {
        // 将来实际业务中 Colleage 的 add  和 University add 不一定完全一样
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
        System.out.println("|--" + getName());
        //遍历
        organizationComponents.forEach(item -> item.print());

    }
}
