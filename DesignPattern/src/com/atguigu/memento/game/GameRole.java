package com.atguigu.memento.game;

/**
 *@description: 
 *@author: ��С��
 *@time: 2020/12/24 10:13
 */
public class GameRole {
    private int vit; //������
    private int def; //������

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

    // ����Memento,�����ݵ�ǰ��״̬�õ�Memento
    public Memento createMemento(){
        return new Memento(vit, def);
    }

    // �ӱ���¼���󣬻ָ���GameRole��״̬
    public void recoverGameRoleFromMemento(Memento memento){
        this.vit = memento.getVit();
        this.def = memento.getDel();

    }

    //��ʾ��ǰ��Ϸ��ɫ��״̬
    public void display(){
        System.out.println("��Ϸ��ɫ��ǰ������:" + this.vit + ",������:" + this.def);
    }
}
