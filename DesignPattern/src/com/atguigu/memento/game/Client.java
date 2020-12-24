package com.atguigu.memento.game;

/**
 *@description: 
 *@author: ��С��
 *@time: 2020/12/24 10:21
 */
public class Client {
    public static void main(String[] args) {
        //������Ϸ��ɫ
        GameRole gameRole = new GameRole();
        gameRole.setVit(100);
        gameRole.setDef(100);

        System.out.println("----��Boss��սǰ��״̬----");
        gameRole.display();

        //�ѵ�ǰ״̬���浽����¼
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(gameRole.createMemento());

        System.out.println("----��Boss��ս----");
        gameRole.setVit(30);
        gameRole.setDef(30);
        gameRole.display();

        System.out.println("---��ս��ʹ�ñ���¼����ָ�---");
        gameRole.recoverGameRoleFromMemento(caretaker.getMemento());
        System.out.println("---�ָ����״̬---");
        gameRole.display();
    }
}
