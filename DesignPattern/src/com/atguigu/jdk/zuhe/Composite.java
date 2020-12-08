package com.atguigu.jdk.zuhe;

import java.util.HashMap;
import java.util.Map;

/**
 *@description: 组合jdk实例
 *@author: 徐小康
 *@time: 2020/12/8 15:59
 */
public class Composite {
    public static void main(String[] args) {
        //1.Map 就是一个抽象的构建（类似我们的Component）
        //2.HashMap 相当于是一个中间的构建(Composite) 实现了相关方法
        //  put , putall
        //3.Node 是HashMap的一个静态内部类，类似叶子节点（Leaf） 这里没有  put  putall remove等方法
        //static class Node<K,V> implements Map.Entry<K,V> {

        Map<Integer, String > hashMap = new HashMap<>();
        hashMap.put(0, "东游记"); //直接存放叶子节点

        Map<Integer, String > map = new HashMap<>();
        map.put(1, "西游记");
        map.put(2, "三国");
        hashMap.putAll(map);
        System.out.println(hashMap);

    }
}
