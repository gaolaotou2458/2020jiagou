package com.atguigu.command;

/**
 *@description: 
 *@author: ��С��
 *@time: 2020/12/16 9:56
 */
public class TVOffCommand implements Command{
    TVReceiver tv;

    public TVOffCommand(TVReceiver tv){
        this.tv = tv;
    }

    //�ۺ�LightReceiver
    @Override
    public void execute() {
        //���ý����ߵķ���
        tv.off();
    }

    //���� ������
    @Override
    public void undo() {
        tv.on();
    }
}
