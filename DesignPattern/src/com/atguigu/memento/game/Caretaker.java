package com.atguigu.memento.game;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *@description: �ػ��߶��󣬸��𱣴���Ϸ��ɫ��״̬
 *@author: ��С��
 *@time: 2020/12/24 10:12
 */
public class Caretaker {
    // ���ֻ����һ��״̬
    private Memento memento;
    // �����ԭʼ���󱣴���״̬
    //private ArrayList<Memento> mementos = new ArrayList<>();
    //�Զ����Ϸ��ɫ������״̬
    //private HashMap<String, ArrayList<Memento>> roles = new HashMap<>();


    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
