package com.gupaoedu.vip.spring;

import com.gupaoedu.vip.spring.demo.action.MyAction;
import com.gupaoedu.vip.spring.demo.service.impl.QueryService;
import com.gupaoedu.vip.spring.formework.context.GPApplicationContext;

/**
 * @ClassName: Test
 * @Description:
 * @Author: xuxk
 * @Date: 2021-01-21 14:15
 * @Version: 1.0
 **/
public class Test {
    public static void main(String[] args) {
        GPApplicationContext context = new GPApplicationContext("classpath:application.properties");
        Object object = null;
        try {
            object = context.getBean("myAction");
            //object = context.getBean(MyAction.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(object);
    }
}
