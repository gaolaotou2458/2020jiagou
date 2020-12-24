package com.atguigu.memento.game;

/**
 *@description: 备忘录对象
 *@author: 徐小康
 *@time: 2020/12/24 10:10
 */
public class Memento {
    private int vit; //攻击力
    private int del; //防御力

    public Memento(int vit, int del) {
        super();
        this.vit = vit;
        this.del = del;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }
}
