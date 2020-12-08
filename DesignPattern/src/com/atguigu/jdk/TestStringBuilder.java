package com.atguigu.jdk;

/**
 *
 *
 *@description: 
 *@author: –Ï–°øµ
 *@time: 2020/12/1 15:57
 * 
 */
public class TestStringBuilder {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("hello,world");
        stringBuilder.append(1);
        stringBuilder.append(true);
        System.out.println(stringBuilder);
    }
}
