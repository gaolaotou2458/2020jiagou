package com.atguigu.command;

/**
 *@description: 
 *@author: 徐小康
 *@time: 2020/12/16 9:56
 */
public class LightOffCommand implements Command{
    LightReceiver light;

    public LightOffCommand(LightReceiver light){
        this.light = light;
    }

    //聚合LightReceiver
    @Override
    public void execute() {
        //调用接受者的方法
        light.off();
    }

    //撤销 反操作
    @Override
    public void undo() {
        light.on();
    }
}
