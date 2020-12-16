package com.atguigu.command;

/**
 *@description: ң���� �ۺϺӶ�����
 *@author: ��С��
 *@time: 2020/12/16 10:12
 */
public class RemoteController {
    //�� ��ť����������
    Command[] onCommands;
    Command[] offCommands;

    //ִ�г����������ס�����һ������
    Command undoCommand;

    //����������ɶ԰�ť�ĳ�ʼ��
    public RemoteController(){
        onCommands = new Command[5];
        offCommands = new Command[5];

        for(int i=0;i<5;i++){
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    //�����ǵİ�ť��������Ҫ������
    public void setCommand(int no, Command onCommand, Command offCommand) {
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;

    }

    //���¿��İ�ť onButtonWasPushed
    public void  onButtonWasPushed(int no) { // no 0
        //�ҵ��㰴�µĿ��İ�ť�������ö�Ӧ�ķ���
        onCommands[no].execute();
        //��¼��εĲ��������ڳ���
        undoCommand = onCommands[no];
    }

    //���¹صİ�ť offButtonWasPushed
    public void  offButtonWasPushed(int no) { // no 0
        //�ҵ��㰴�µĿ��İ�ť�������ö�Ӧ�ķ���
        offCommands[no].execute();
        //��¼��εĲ��������ڳ���
        undoCommand = offCommands[no];
    }

    //���³�����ť�Ĵ���
    public void undoButtonWasPushed(){
        undoCommand.undo();
    }
}
