package com.atguigu.command;

/**
 *@description: 
 *@author: 徐小康
 *@time: 2020/12/16 9:56
 */
public class TVOnCommand implements Command{
    TVReceiver tv;

    public TVOnCommand(TVReceiver tv){
        this.tv = tv;
    }

    //聚合LightReceiver
    @Override
    public void execute() {
        //调用接受者的方法
        tv.on();
    }

    //撤销 反操作
    @Override
    public void undo() {
        tv.off();
    }
}
