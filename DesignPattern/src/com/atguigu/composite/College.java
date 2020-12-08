package com.atguigu.composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *@description: ѧԺ-��Ҷ�ӽڵ�
 *@author: ��С��
 *@time: 2020/12/8 13:27
 * 
 */
public class College extends OrganizationComponent{

    //���List��ŵ���Department
    List<OrganizationComponent> organizationComponents = new ArrayList<OrganizationComponent>();

    public College(String name, String des) {
        super(name, des);
    }



    //��дadd����
    @Override
    protected void add(OrganizationComponent organizationComponent) {
        // ����ʵ��ҵ���� Colleage �� add  �� University add ��һ����ȫһ��
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

    //print �������������University ������ѧԺ
    @Override
    protected void print() {
        System.out.println("|--" + getName());
        //����
        organizationComponents.forEach(item -> item.print());

    }
}
