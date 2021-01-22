package com.gupaoedu.vip.spring.formework.beans.config;

import lombok.Data;

/**
 * @ClassName: BeanDefinition
 * @Description: 存储配置信息
 * @Author: xuxk
 * @Date: 2021-01-18 09:55
 * @Version: 1.0
 **/
@Data
public class GPBeanDefinition {

    private String beanClassName;
    private boolean lazyInit = false;
    private String factoryBeanName;
    private  boolean isSingleton = true;


}
