package com.atguigu.visitor;

/**
 *@description: 
 *@author: –Ï–°øµ
 *@time: 2020/12/18 10:21
 */
public class Client {
    public static void main(String[] args) {

        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new Man());
        objectStructure.attach(new Women());
        //≥…π¶
        Success success = new Success();
        objectStructure.display(success);

        System.out.println("===========");
        Fail fail = new Fail();
        objectStructure.display(fail);

    }
}
