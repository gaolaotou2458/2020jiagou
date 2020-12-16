package com.atguigu.command;

/**
 *@description: 
 *@author: 徐小康
 *@time: 2020/12/16 10:36
 */
public class Client {

    public static void main(String[] args) {

        //使用命令模式，完成通过遥控器，对点灯的操作

        //创建点灯的对象（接受者）
        LightReceiver lightReceiver = new LightReceiver();

        //创建点灯相关的开关命令
        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);

        //需要一个遥控器
        RemoteController remoteController = new RemoteController();
        //给遥控器设置相关命令 no = 0 点灯的开关
        remoteController.setCommand(0,lightOnCommand,lightOffCommand);

        System.out.println("----按下灯的开按钮");
        remoteController.onButtonWasPushed(0);
        System.out.println("----按下灯的关按钮");
        remoteController.offButtonWasPushed(0);
        System.out.println("----按下灯的撤销按钮");
        remoteController.undoButtonWasPushed();

        //创建TV接受者
        TVReceiver tvReceiver = new TVReceiver();
        TVOnCommand tvOnCommand = new TVOnCommand(tvReceiver);
        TVOffCommand tvOffCommand = new TVOffCommand(tvReceiver);
        remoteController.setCommand(1, tvOnCommand, tvOffCommand);
        System.out.println("----按下TV的开按钮");
        remoteController.onButtonWasPushed(1);
        System.out.println("----按下TV的关按钮");
        remoteController.offButtonWasPushed(1);
        System.out.println("----按下TV的撤销按钮");
        remoteController.undoButtonWasPushed();



    }
}
