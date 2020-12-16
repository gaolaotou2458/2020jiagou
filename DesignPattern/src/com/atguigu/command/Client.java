package com.atguigu.command;

/**
 *@description: 
 *@author: ��С��
 *@time: 2020/12/16 10:36
 */
public class Client {

    public static void main(String[] args) {

        //ʹ������ģʽ�����ͨ��ң�������Ե�ƵĲ���

        //������ƵĶ��󣨽����ߣ�
        LightReceiver lightReceiver = new LightReceiver();

        //���������صĿ�������
        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);

        //��Ҫһ��ң����
        RemoteController remoteController = new RemoteController();
        //��ң��������������� no = 0 ��ƵĿ���
        remoteController.setCommand(0,lightOnCommand,lightOffCommand);

        System.out.println("----���µƵĿ���ť");
        remoteController.onButtonWasPushed(0);
        System.out.println("----���µƵĹذ�ť");
        remoteController.offButtonWasPushed(0);
        System.out.println("----���µƵĳ�����ť");
        remoteController.undoButtonWasPushed();

        //����TV������
        TVReceiver tvReceiver = new TVReceiver();
        TVOnCommand tvOnCommand = new TVOnCommand(tvReceiver);
        TVOffCommand tvOffCommand = new TVOffCommand(tvReceiver);
        remoteController.setCommand(1, tvOnCommand, tvOffCommand);
        System.out.println("----����TV�Ŀ���ť");
        remoteController.onButtonWasPushed(1);
        System.out.println("----����TV�Ĺذ�ť");
        remoteController.offButtonWasPushed(1);
        System.out.println("----����TV�ĳ�����ť");
        remoteController.undoButtonWasPushed();



    }
}
