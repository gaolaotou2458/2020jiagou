package com.atguigu.visitor;

/**
 *@description: 
 *@author: ��С��
 *@time: 2020/12/18 10:21
 */
public class Client {
    public static void main(String[] args) {

        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new Man());
        objectStructure.attach(new Women());
        //�ɹ�
        Success success = new Success();
        objectStructure.display(success);

        System.out.println("===========");
        Fail fail = new Fail();
        objectStructure.display(fail);

    }
}
