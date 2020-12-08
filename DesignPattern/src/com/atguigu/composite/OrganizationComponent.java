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

    public OrganizationComponent(String name, String des) {
        this.name = name;
        this.des = des;
    }

    //这里不写抽象方法，因为叶子节点不实现全部方法
    protected void add(OrganizationComponent organizationComponent) {
        //默认实现 不支持操作夜场
        throw new UnsupportedOperationException();
    }

    protected void remove(OrganizationComponent organizationComponent){
        //默认实现 不支持操作夜场
        throw new UnsupportedOperationException();
    }

    //必须全部都有的方法 子类都需要实现
    protected abstract void print();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
