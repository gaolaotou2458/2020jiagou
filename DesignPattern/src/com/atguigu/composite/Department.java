package com.atguigu.composite;

/**
 *
 *
 *@description: ϵ-Ҷ�ӽڵ�
 *@author: ��С��
 *@time: 2020/12/8 13:27
 * 
 */
public class Department extends OrganizationComponent{

    //û�оۺ�

    public Department(String name, String des) {
        super(name, des);
    }



    // add , remove �Ͳ���д�ˣ���Ϊ����Ҷ�ӽڵ�


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
