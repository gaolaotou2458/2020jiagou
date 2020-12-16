package com.atguigu.command;

/**
 *@description: 遥控器 聚合河东命令
 *@author: 徐小康
 *@time: 2020/12/16 10:12
 */
public class RemoteController {
    //开 按钮的命令数组
    Command[] onCommands;
    Command[] offCommands;

    //执行撤销的命令，记住最近的一次命令
    Command undoCommand;

    //构造器，完成对按钮的初始化
    public RemoteController(){
        onCommands = new Command[5];
        offCommands = new Command[5];

        for(int i=0;i<5;i++){
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    //给我们的按钮设置你需要的命令
    public void setCommand(int no, Command onCommand, Command offCommand) {
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;

    }

    //按下开的按钮 onButtonWasPushed
    public void  onButtonWasPushed(int no) { // no 0
        //找到你按下的开的按钮，并调用对应的方法
        onCommands[no].execute();
        //记录这次的操作，用于撤销
        undoCommand = onCommands[no];
    }

    //按下关的按钮 offButtonWasPushed
    public void  offButtonWasPushed(int no) { // no 0
        //找到你按下的开的按钮，并调用对应的方法
        offCommands[no].execute();
        //记录这次的操作，用于撤销
        undoCommand = offCommands[no];
    }

    //按下撤销按钮的处理
    public void undoButtonWasPushed(){
        undoCommand.undo();
    }
}
