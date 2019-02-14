package com.hxy.blog.controller;


import com.hxy.blog.entity.UserIp;
import com.hxy.blog.service.UserIpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/userIp")
public class UserIpController {
    @Autowired
    private UserIpService userIpServiceImpl;


    @RequestMapping("/saveUserIp")
    public Integer saveUserIp(UserIp userIp, HttpServletRequest request , Model model)throws Exception{
        userIp.setUserId(Long.valueOf(123));
        userIp.setIpInfo("123.124.125.126");
        return userIpServiceImpl.saveUserIp(userIp);
    }

    @RequestMapping("/findUserIpAll")
    public List<UserIp> findUserIpAll(HttpServletRequest request , Model model)throws Exception{
        return userIpServiceImpl.findUserIpAll();
    }

    @RequestMapping("/findUserIp")
    public UserIp findUserIp(HttpServletRequest request , Model model , UserIp userIp)throws Exception{
//        userIp.setIpInfo("123.123.123.123");
        return userIpServiceImpl.findUserIp("123.123.123.123");
    }
}
