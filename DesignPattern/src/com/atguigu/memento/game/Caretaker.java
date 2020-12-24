package com.atguigu.memento.game;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *@description: 守护者对象，负责保存游戏角色的状态
 *@author: 徐小康
 *@time: 2020/12/24 10:12
 */
public class Caretaker {
    // 如果只保存一次状态
    private Memento memento;
    // 如果对原始对象保存多次状态
    //private ArrayList<Memento> mementos = new ArrayList<>();
    //对多个游戏角色保存多个状态
    //private HashMap<String, ArrayList<Memento>> roles = new HashMap<>();


    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
