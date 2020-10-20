package com.gupaoedu.vip.pattern.prototype.deep;


public class DeepCloneTest {

    public static void main(String[] args) {

        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
        try {
            System.out.println(qiTianDaSheng);
            QiTianDaSheng clone = (QiTianDaSheng)qiTianDaSheng.clone();
            clone.height =2;
            System.out.println(clone);
            System.out.println("深克隆：" + (qiTianDaSheng.jinGuBang == clone.jinGuBang));
        } catch (Exception e) {
            e.printStackTrace();
        }

        QiTianDaSheng q = new QiTianDaSheng();
        q.height = 3;
        QiTianDaSheng n = q.shallowClone(q);
        System.out.println("浅克隆：" + (q.jinGuBang == n.jinGuBang));
        System.out.println(q);
        System.out.println(n);


    }
}
