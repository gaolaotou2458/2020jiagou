package com.atguigu.command;

/**
 *@description: ��������ӿ�
 *@author: ��С��
 *@time: 2020/12/16 9:45
 */
public interface Command {
    //ִ�ж���(����)
    public void execute();

    //����������������
    public void undo();


}
