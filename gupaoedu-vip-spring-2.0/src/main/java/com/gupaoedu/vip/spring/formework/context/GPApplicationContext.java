package com.gupaoedu.vip.spring.formework.context;


import com.gupaoedu.vip.spring.formework.beans.GPBeanFactory;
import com.gupaoedu.vip.spring.formework.beans.support.GPDefaultListableBeanFactory;

/**
 * @ClassName: GPApplicationContext
 * @Description: 最底层容器实现
 * @Author: xuxk
 * @Date: 2021-01-18 09:04
 * @Version: 1.0
 **/
public class GPApplicationContext extends GPDefaultListableBeanFactory implements GPBeanFactory {
    @Override
    public Object getBean(String beanName) {
        return null;
    }

    @Override
    public void refresh() throws Exception {
        super.refresh();
    }
}
