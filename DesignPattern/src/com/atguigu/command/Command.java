package com.atguigu.command;

/**
 *@description: 创建命令接口
 *@author: 徐小康
 *@time: 2020/12/16 9:45
 */
public interface Command {
    //执行动作(操作)
    public void execute();

    //撤销动作（操作）
    public void undo();


}
