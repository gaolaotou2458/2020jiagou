package com.atguigu.memento.game;

/**
 *@description: 
 *@author: 徐小康
 *@time: 2020/12/24 10:13
 */
public class GameRole {
    private int vit; //攻击力
    private int def; //防御力

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    // 创建Memento,即根据当前的状态得到Memento
    public Memento createMemento(){
        return new Memento(vit, def);
    }

    // 从备忘录对象，恢复到GameRole的状态
    public void recoverGameRoleFromMemento(Memento memento){
        this.vit = memento.getVit();
        this.def = memento.getDel();

    }

    //显示当前游戏角色的状态
    public void display(){
        System.out.println("游戏角色当前攻击力:" + this.vit + ",防御力:" + this.def);
    }
}
