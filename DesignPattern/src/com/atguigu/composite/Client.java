package com.atguigu.composite;

/**
 *
 *
 *@description: 
 *@author: ��С��
 *@time: 2020/12/8 13:25
 * 
 */
public class Client {

    public static void main(String[] args) {
        //�Ӵ�С��������  ѧУ
        OrganizationComponent university = new University("�廪��ѧ", "�й�������ѧ");

        //����ѧԺ
        OrganizationComponent computerCollege = new College("�����ѧԺ", "�����ѧԺ");
        OrganizationComponent infoEnginnerCollege = new College("��Ϣ����ѧԺ", "��Ϣ����ѧԺ");

        //����רҵ
        computerCollege.add(new Department("�������רҵ", "�������רҵ"));
        computerCollege.add(new Department("���繤��רҵ", "���繤��רҵ"));
        computerCollege.add(new Department("�������ѧ�뼼��רҵ", "�������ѧ�뼼��רҵ"));

        //
        infoEnginnerCollege.add(new Department("ͨѶ����רҵ", "����ѧ"));
        infoEnginnerCollege.add(new Department("��Ϣ����רҵ", "��ѧ"));

        //ѧԺ����ѧУ
        university.add(computerCollege);
        university.add(infoEnginnerCollege);


        computerCollege.print();
        System.out.println("====================");
        university.print();
    }
}
