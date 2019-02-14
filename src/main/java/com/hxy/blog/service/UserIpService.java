package com.hxy.blog.service;


import com.hxy.blog.entity.UserIp;

import java.util.List;

public interface UserIpService {

    //存入IP
    Integer saveUserIp(UserIp userIp);

    //查询IP列表
    List<UserIp> findUserIpAll();

    //查询某一个IP
    UserIp findUserIp(String ipInfo);
}
