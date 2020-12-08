package com.imooc.java.escape;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>理解泛型</h1>
 * */
@SuppressWarnings("all")
public class Genericity {

    /**
     * <h2>简单使用泛型</h2>
     * 属性擦除
     * */
    private static void easyUse() throws Exception {
        List<String> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        System.out.println(left.getClass());
        System.out.println(right.getClass() == left.getClass()); //true

        //判断是否是集合类型
        if(left instanceof ArrayList){

        }

        if(left instanceof ArrayList<?>){

        }

        //测试反射运行时添加其他类型数据
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.getClass().getMethod("add", Object.class).invoke(list, "abc");
        list.getClass().getMethod("add", Object.class).invoke(list, 1.2);

        System.out.println("============");
        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
        System.out.println("===============");
        list.stream().forEach(System.out::println);





    }


    /**
     *@描述 先检查再编译
     *@创建人 徐小康
     *@创建时间 2020/11/23
     *@修改人和其它信息
     */
    private static void checkAndCompile(){

        List<String> list= new ArrayList<>();
        list.add("1234");
        //list.add(1);
    }

    /**
     * 泛型不支持集成
     */
    private static void genericityCanNotExtend(){

        //第一类错误 不能继承
//        ArrayList<String> first = new ArrayList<Object>();
//
//        ArrayList<Object> list1 = new ArrayList<>();
//        list1.add(new Object());
//        ArrayList<String> list2 = list1;

        //第二类错误
        //ArrayList<Object> second = new ArrayList<String>();


    }

    /**
     * 泛型类型变量不能是基本数据类型
     */
    private static void baseTypeCanNotGenericity() {

        //List<int>
    }

    /**
     * 泛型的类型参数只能是类类型，不能是简单类型
     * @param values
     * @param <T>
     */
    private static <T> void doSomething(T... values){
        for(T value : values) {
            System.out.println(value);
        }
    }


    public static void main(String[] args) throws Exception {
        //easyUse();

        Integer[] ints1 = new Integer[]{1,2,3};
        int[] intZ = new int[]{1,2,3};
        doSomething(ints1);
        System.out.println("=========");
        doSomething(intZ);
    }
}
