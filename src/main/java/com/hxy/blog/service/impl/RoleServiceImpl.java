package com.hxy.blog.service.impl;

import com.hxy.blog.dao.RoleMapper;
import com.hxy.blog.entity.Role;
import com.hxy.blog.entity.User;
import com.hxy.blog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Integer saveRole(Role role) {
        return roleMapper.saveRole(role);
    }

    @Override
    public User findUser(User user) {
        return roleMapper.findUser(user);
    }

    @Override
    public Role findRole(Long userId) {
        return roleMapper.findRole(userId);
    }

    @Override
    public List<User> findRoleUser() {
        return roleMapper.findRoleUser();
    }

    @Override
    public Integer delRoleUser(Long userId) {
        return roleMapper.delRoleUser(userId);
    }
}
