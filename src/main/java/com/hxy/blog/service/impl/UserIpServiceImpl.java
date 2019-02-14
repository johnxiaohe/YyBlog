package com.hxy.blog.service.impl;

import com.hxy.blog.dao.UserIpMapper;
import com.hxy.blog.entity.UserIp;
import com.hxy.blog.service.UserIpService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserIpServiceImpl implements UserIpService {

    @Autowired
    private UserIpMapper userIpMapper;

    @Override
    public Integer saveUserIp(UserIp userIp) {
        return userIpMapper.saveUserIp(userIp);
    }

    @Override
    public List<UserIp> findUserIpAll() {
        return userIpMapper.findUserIpAll();
    }

    @Override
    public UserIp findUserIp(String ipInfo) {
        return userIpMapper.findUserIp(ipInfo);
    }
}
