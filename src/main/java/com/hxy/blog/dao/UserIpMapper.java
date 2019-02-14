package com.hxy.blog.dao;

import com.hxy.blog.entity.UserIp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 查询用户Ip列表 注册时存入用户IP
 */
@Mapper
public interface UserIpMapper {

    //存入IP
    Integer saveUserIp(UserIp userIp);

    //查询IP列表
    List<UserIp> findUserIpAll();

    //查询某一个IP
    UserIp findUserIp(String ipInfo);

}
