package com.atguigu.jdk.zuhe;

import java.util.HashMap;
import java.util.Map;

/**
 *@description: ���jdkʵ��
 *@author: ��С��
 *@time: 2020/12/8 15:59
 */
public class Composite {
    public static void main(String[] args) {
        //1.Map ����һ������Ĺ������������ǵ�Component��
        //2.HashMap �൱����һ���м�Ĺ���(Composite) ʵ������ط���
        //  put , putall
        //3.Node ��HashMap��һ����̬�ڲ��࣬����Ҷ�ӽڵ㣨Leaf�� ����û��  put  putall remove�ȷ���
        //static class Node<K,V> implements Map.Entry<K,V> {

        Map<Integer, String > hashMap = new HashMap<>();
        hashMap.put(0, "���μ�"); //ֱ�Ӵ��Ҷ�ӽڵ�

        Map<Integer, String > map = new HashMap<>();
        map.put(1, "���μ�");
        map.put(2, "����");
        hashMap.putAll(map);
        System.out.println(hashMap);

    }
}
