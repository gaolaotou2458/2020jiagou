package com.atguigu.command;

/**
 *@description: û���κ��������ִ�У����ڳ�ʼ��ÿ����ť�������ÿ�����ʱ������ʲô����Ҳ��������
 * ��ʵ������һ�����ģʽ������ʡ�ԶԿյ��ж�
 *@author: ��С��
 *@time: 2020/12/16 10:06
 */
public class NoCommand implements Command{
    @Override
    public void execute() {
        System.out.println("ʲôҲ������");
    }

    @Override
    public void undo() {
        System.out.println("ʲôҲ������");
    }
}
