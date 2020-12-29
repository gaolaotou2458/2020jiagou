package com.atguigu.visitor;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.List;

/**
 *@description: 
 *@author: ��С��
 *@time: 2020/12/18 10:15
 */
public class ObjectStructure {
    //ά����һ������
    private List<Person> persons = new LinkedList<>();

    //���ӵ�list
    public void attach(Person p){
        persons.add(p);
    }

    //�Ƴ�
    public void detach(Person p){
        persons.remove(p);
    }

    //��ʾ�������
    public void display(Action action){
        persons.forEach(p -> p.accept(action));
    }
}
