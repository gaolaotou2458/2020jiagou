package com.atguigu.composite;

/**
 *
 *
 *@description: ����һЩ��صķ���
 * �����ǳ��󷽷������巽���������ǽṹ
 *@author: ��С��
 *@time: 2020/12/8 13:26
 * 
 */
public abstract class OrganizationComponent {

    private String name; //����
    private String des; // ˵��

    public OrganizationComponent(String name, String des) {
        this.name = name;
        this.des = des;
    }

    //���ﲻд���󷽷�����ΪҶ�ӽڵ㲻ʵ��ȫ������
    protected void add(OrganizationComponent organizationComponent) {
        //Ĭ��ʵ�� ��֧�ֲ���ҹ��
        throw new UnsupportedOperationException();
    }

    protected void remove(OrganizationComponent organizationComponent){
        //Ĭ��ʵ�� ��֧�ֲ���ҹ��
        throw new UnsupportedOperationException();
    }

    //����ȫ�����еķ��� ���඼��Ҫʵ��
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
