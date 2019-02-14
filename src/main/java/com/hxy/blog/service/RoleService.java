package com.hxy.blog.service;

import com.hxy.blog.entity.Role;
import com.hxy.blog.entity.User;

import java.util.List;

public interface RoleService {

    Integer saveRole(Role role);

    User findUser(User user);

    Role findRole(Long userId);

    List<User> findRoleUser();

    Integer delRoleUser(Long userId);
}
