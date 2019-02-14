package com.hxy.blog.dao;

import com.hxy.blog.entity.Role;
import com.hxy.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 实现 查询是否有该用户在后台表中 存入该用户在后台表 查找用户后台所有数据 取消后台权限（删除后台用户）
 */
@Mapper
public interface RoleMapper {

    Integer saveRole(Role role);

    User findUser(User user);

    Role findRole(Long userId);

    List<User> findRoleUser();

    Integer delRoleUser(Long userId);



}
