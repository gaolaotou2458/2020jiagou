package com.atguigu.memento.theory;


import java.util.ArrayList;
import java.util.List;

/**
 *@description: �ػ��߶��󣬸��𱣴�������¼����
 *@author: ��С��
 *@time: 2020/12/24 9:36
 */
public class Caretaker {
    // ��List �����л��кܶ�ı���¼����
    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    //��ȡ����index��Originator�� ����¼���󣨼�����״̬��
    public Memento get(int index) {
        return mementoList.get(index);
    }
}
