package com.hxy.blog.service;

import com.hxy.blog.entity.User;
import com.hxy.blog.util.PageBean;

import java.util.List;

public interface UserService {

    //用户注册
    Integer saveUser(User user);
    //修改密码
    Integer updateUser(User user);

    //查询所有用户
    List<User> findUserAll();

    //查询单个用户
    User findUser(Long id);

    User userLogin(User user);

}
