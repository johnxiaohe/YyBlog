package com.hxy.blog.dao;

import com.hxy.blog.entity.User;
import com.hxy.blog.util.PageBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 实现功能  用户注册 修改用户信息 查询用户列表 查询单个用户
 */
@Mapper
public interface UserMapper {

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
