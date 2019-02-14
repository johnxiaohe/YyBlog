package com.hxy.blog.controller;

import com.alibaba.druid.util.StringUtils;
import com.hxy.blog.entity.Role;
import com.hxy.blog.entity.User;
import com.hxy.blog.service.RoleService;
import com.hxy.blog.service.UserService;
import com.hxy.blog.util.MD5Util;
import com.hxy.blog.util.ReturnDatas;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleServiceImpl;
    @Autowired
    private UserService userService;

    @RequestMapping("/saveRole")
    public void saveRole(HttpServletRequest request , Model model , Role role)throws Exception{
        roleServiceImpl.saveRole(role);
    }

    @RequestMapping("/findUser")
    public User findUser(HttpServletRequest request , Model model , User user)throws Exception{
        user.setId(Long.valueOf(1));
        return roleServiceImpl.findUser(user);
    }

    @RequestMapping("/findRole")
    public Role findRole(HttpServletRequest request , Model model , Role role)throws Exception{
        return roleServiceImpl.findRole(role.getUserId());
    }

    @RequestMapping("/findRoleUser")
    public List<User> findRoleUser(HttpServletRequest request , Model model )throws Exception{
        return roleServiceImpl.findRoleUser();
    }

    @RequestMapping("/delRoleUser")
    public void delRoleUser(HttpServletRequest request , Model model , Role role)throws Exception{
        roleServiceImpl.delRoleUser(role.getUserId());
    }

    @RequestMapping("/login/json")
    @ResponseBody
    public ReturnDatas loginJson(HttpServletRequest request , Model model , User user)throws Exception{
        ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
        returnObject.setMessage("登录成功");
        user.setPassword(MD5Util.md5(user.getPassword()));
        user.setDark(0);
        User user1 = userService.userLogin(user);
        if(user1==null){
            return new ReturnDatas(ReturnDatas.ERROR,"登录失败无此用户");
        }

        Role role = roleServiceImpl.findRole(user1.getId());
        if(role == null){
            return new ReturnDatas(ReturnDatas.ERROR,"此用户不是管理员");
        }
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("userId",user1.getId());
        httpSession.setAttribute("username",user1.getNickname());
        httpSession.setAttribute("userheader",user1.getHeader());

        returnObject.setData(user1);
        return returnObject;
    }
    @RequestMapping("/login")
    public String login(HttpServletRequest request , Model model , User user)throws Exception{

        return "admin/htIndex";
    }


}
