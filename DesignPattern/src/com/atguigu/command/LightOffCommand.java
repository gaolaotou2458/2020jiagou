package com.atguigu.command;

/**
 *@description: 
 *@author: ��С��
 *@time: 2020/12/16 9:56
 */
public class LightOffCommand implements Command{
    LightReceiver light;

    public LightOffCommand(LightReceiver light){
        this.light = light;
    }

    //�ۺ�LightReceiver
    @Override
    public void execute() {
        //���ý����ߵķ���
        light.off();
    }

    //���� ������
    @Override
    public void undo() {
        light.on();
    }
}
