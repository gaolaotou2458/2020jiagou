package com.gupaoedu.vip.spring.formework.aop.config;

import lombok.Data;

/**
 * @ClassName: GPAopConfig
 * @Description:
 * @Author: xuxk
 * @Date: 2021-01-27 09:55
 * @Version: 1.0
 **/
@Data
public class GPAopConfig {
    private String pointCut;

    private String aspectBefore;

    private String aspectAfter;

    private String aspectClass;

    private String aspectAfterThrow;

    private String aspectAfterThrowingName;

}
