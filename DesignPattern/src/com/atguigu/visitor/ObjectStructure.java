package com.atguigu.visitor;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.List;

/**
 *@description: 
 *@author: 徐小康
 *@time: 2020/12/18 10:15
 */
public class ObjectStructure {
    //维护了一个集合
    private List<Person> persons = new LinkedList<>();

    //增加到list
    public void attach(Person p){
        persons.add(p);
    }

    //移除
    public void detach(Person p){
        persons.remove(p);
    }

    //显示测评结果
    public void display(Action action){
        persons.forEach(p -> p.accept(action));
    }
}
