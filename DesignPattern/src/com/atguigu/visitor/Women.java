package com.atguigu.visitor;

/**
 *@description: 
 *@author: ��С��
 *@time: 2020/12/18 9:51
 * ˵����
 * 1.����ʹ����˫���ɣ������ڿͻ��˳����У�������״̬��Ϊ��������Woman�У���һ�η��ɣ�
 * 2��Ȼ��Woman�������Ϊ�����ġ����巽������getWomenResult��ͬʱ���Լ���this����Ϊ����
 * ���ݣ���ɶ��η���
 */
public class Women extends Person {
    @Override
    public void accept(Action action) {
        action.getWomenResult(this);
    }
}
