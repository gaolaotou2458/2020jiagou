package java.escape.nullpointdemo;

/**
 * 理解什么是空指针
 */

public class WhatIsNpe {

    public static class User{
        private String name;
        private String[] address;

        public void print(){
            System.out.println("This is User Class!");
        }

        public String readBook(){
            System.out.println("User ReadBook()");
            return null;
        }
    }

    //自定义个运行时异常
    public static class CustomException extends  RuntimeException{

    }

    public static void main(String[] args) {
        // 第一种情况：调用了空对象的实例方法
        //User user = null;
        //user.print();

        //第二种情况：访问空对象的属性
        //user.name;

        //第三种情况，当数组是一个空对象的时候，取它的长度
        //User user = new User();
        //System.out.println(user.address.length);

        //第四种情况：null当做 Throwable的值
//        CustomException customException = null;
//        throw customException;

        // 第五种情况，方法的返回值是Null，对象直接去使用
        User user = new User();
        


    }
}
