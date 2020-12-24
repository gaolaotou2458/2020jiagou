package com.atguigu.memento.theory;

/**
 *@description: 
 *@author: ��С��
 *@time: 2020/12/24 9:39
 */
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState(" ״̬#1 ������100");
        //�����˵�ǰ��״̬
        caretaker.add(originator.saveStateMemento());

        originator.setState(" ״̬#2 ������80");
        caretaker.add(originator.saveStateMemento());

        originator.setState(" ״̬#3 ������50");
        caretaker.add(originator.saveStateMemento());

        //ϣ���ָ���״̬2
        System.out.println("��ǰ��״̬��"+ originator.getState());
        originator.getStateFromMemento(caretaker.get(1));
        System.out.println("�ָ�����״̬��"+ originator.getState());
    }
}
