package com.atguigu.command;

/**
 *@description: 没有任何命令，即空执行：用于初始化每个按钮，党调用空命令时，对象什么事情也不做即可
 * 其实，这样一种设计模式，可以省略对空的判断
 *@author: 徐小康
 *@time: 2020/12/16 10:06
 */
public class NoCommand implements Command{
    @Override
    public void execute() {
        System.out.println("什么也不做！");
    }

    @Override
    public void undo() {
        System.out.println("什么也不做！");
    }
}
