package com.atguigu.memento.game;

/**
 *@description: 
 *@author: 徐小康
 *@time: 2020/12/24 10:21
 */
public class Client {
    public static void main(String[] args) {
        //创建游戏角色
        GameRole gameRole = new GameRole();
        gameRole.setVit(100);
        gameRole.setDef(100);

        System.out.println("----和Boss大战前的状态----");
        gameRole.display();

        //把当前状态保存到备忘录
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(gameRole.createMemento());

        System.out.println("----和Boss大战----");
        gameRole.setVit(30);
        gameRole.setDef(30);
        gameRole.display();

        System.out.println("---大战后，使用备忘录对象恢复---");
        gameRole.recoverGameRoleFromMemento(caretaker.getMemento());
        System.out.println("---恢复后的状态---");
        gameRole.display();
    }
}
