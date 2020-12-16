package com.atguigu.command;

/**
 *@description: 
 *@author: ��С��
 *@time: 2020/12/16 9:56
 */
public class LightOnCommand implements Command{
    LightReceiver light;

    public LightOnCommand(LightReceiver light){
        this.light = light;
    }

    //�ۺ�LightReceiver
    @Override
    public void execute() {
        //���ý����ߵķ���
        light.on();
    }

    //���� ������
    @Override
    public void undo() {
        light.off();
    }
}
