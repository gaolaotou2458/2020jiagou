package com.gupaoedu.vip.spring.formework.webmvc.servlet;

import lombok.Data;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @ClassName: GPHandlerMapping
 * @Description:
 * @Author: xuxk
 * @Date: 2021-01-22 13:39
 * @Version: 1.0
 **/
@Data
public class GPHandlerMapping {

    //必须把url放到HandlerMapping才好理解吧
    private Pattern pattern;  //正则
    private Method method;
    private Object controller;

    public GPHandlerMapping(Pattern pattern, Object controller, Method method) {
        this.pattern = pattern;
        this.method = method;
        this.controller = controller;
    }
}
