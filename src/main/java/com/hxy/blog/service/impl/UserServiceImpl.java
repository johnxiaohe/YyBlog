package com.hxy.blog.service.impl;

import com.hxy.blog.dao.UserMapper;
import com.hxy.blog.entity.User;
import com.hxy.blog.service.UserService;
import com.hxy.blog.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer saveUser(User user) {
        return userMapper.saveUser(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public List<User> findUserAll() {
        return userMapper.findUserAll();
    }

    @Override
    public User findUser(Long id) {
        return userMapper.findUser(id);
    }

    @Override
    public User userLogin(User user) {
        return userMapper.userLogin(user);
    }
}
