package com.hxy.blog.interceptor;


import com.alibaba.druid.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    //在之前拦截 postHandle拦截post请求
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userId = String.valueOf(request.getSession().getAttribute("userId"));
        if(StringUtils.isEmpty(userId)){
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }
        return true;
    }


}
