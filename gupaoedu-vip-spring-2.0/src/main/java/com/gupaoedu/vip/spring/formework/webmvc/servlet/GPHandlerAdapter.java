package com.gupaoedu.vip.spring.formework.webmvc.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: GPHandlerAdapter
 * @Description:
 * @Author: xuxk
 * @Date: 2021-01-22 14:38
 * @Version: 1.0
 **/
public class GPHandlerAdapter {
    public boolean supports(Object handler) {
        return (handler instanceof  GPHandlerMapping);
    }

    public GPModelAndView handle(HttpServletRequest request, HttpServletResponse response,Object handler){

        return null;
    }
}
