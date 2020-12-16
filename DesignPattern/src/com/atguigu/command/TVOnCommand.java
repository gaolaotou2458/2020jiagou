package com.atguigu.command;

/**
 *@description: 
 *@author: ��С��
 *@time: 2020/12/16 9:56
 */
public class TVOnCommand implements Command{
    TVReceiver tv;

    public TVOnCommand(TVReceiver tv){
        this.tv = tv;
    }

    //�ۺ�LightReceiver
    @Override
    public void execute() {
        //���ý����ߵķ���
        tv.on();
    }

    //���� ������
    @Override
    public void undo() {
        tv.off();
    }
}
