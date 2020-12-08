package com.atguigu.composite;

/**
 *
 *
 *@description: 
 *@author: 徐小康
 *@time: 2020/12/8 13:25
 * 
 */
public class Client {

    public static void main(String[] args) {
        //从大到小创建对象  学校
        OrganizationComponent university = new University("清华大学", "中国顶级大学");

        //创建学院
        OrganizationComponent computerCollege = new College("计算机学院", "计算机学院");
        OrganizationComponent infoEnginnerCollege = new College("信息工程学院", "信息工程学院");

        //创建专业
        computerCollege.add(new Department("软件工程专业", "软件工程专业"));
        computerCollege.add(new Department("网络工程专业", "网络工程专业"));
        computerCollege.add(new Department("计算机科学与技术专业", "计算机科学与技术专业"));

        //
        infoEnginnerCollege.add(new Department("通讯工程专业", "不好学"));
        infoEnginnerCollege.add(new Department("信息工程专业", "好学"));

        //学院加入学校
        university.add(computerCollege);
        university.add(infoEnginnerCollege);


        computerCollege.print();
        System.out.println("====================");
        university.print();
    }
}
