package com.hxy.blog.config;

import com.hxy.blog.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * MVC模式全局配置
 */
@Configuration
public class MVCConfig implements WebMvcConfigurer {


    /**
     * 登录拦截器配置 配置它拦截路径
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> patterns = new ArrayList<>();
        patterns.add("/toComment");
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns()//拦截配置
                .excludePathPatterns();//过滤配置
    }
}
