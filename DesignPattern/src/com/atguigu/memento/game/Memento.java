package com.atguigu.memento.game;

/**
 *@description: ����¼����
 *@author: ��С��
 *@time: 2020/12/24 10:10
 */
public class Memento {
    private int vit; //������
    private int del; //������

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
