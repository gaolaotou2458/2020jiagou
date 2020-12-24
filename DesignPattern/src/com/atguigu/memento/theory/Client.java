package com.atguigu.memento.theory;

/**
 *@description: 
 *@author: 徐小康
 *@time: 2020/12/24 9:39
 */
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState(" 状态#1 攻击力100");
        //保存了当前的状态
        caretaker.add(originator.saveStateMemento());

        originator.setState(" 状态#2 攻击力80");
        caretaker.add(originator.saveStateMemento());

        originator.setState(" 状态#3 攻击力50");
        caretaker.add(originator.saveStateMemento());

        //希望恢复到状态2
        System.out.println("当前的状态是"+ originator.getState());
        originator.getStateFromMemento(caretaker.get(1));
        System.out.println("恢复到的状态是"+ originator.getState());
    }
}
