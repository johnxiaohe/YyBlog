package com.hxy.blog.controller;

import com.alibaba.druid.util.StringUtils;
import com.hxy.blog.entity.User;
import com.hxy.blog.entity.UserIp;
import com.hxy.blog.service.UserIpService;
import com.hxy.blog.service.UserService;
import com.hxy.blog.util.MD5Util;
import com.hxy.blog.util.PageBean;
import com.hxy.blog.util.ReturnDatas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @Autowired
    private UserIpService userIpServiceImpl;

    @RequestMapping("/saveUser")
    public String saveUser(HttpServletRequest request , Model model , User user  )throws Exception{
        Integer userId = userServiceImpl.saveUser(user);
        return null;
    }
    //更新用户信息
    @RequestMapping("/updateUser")
    @ResponseBody
    public Integer updateUser(HttpServletRequest request , Model model , User user)throws Exception{
        if(user.getId()==null){
            throw new Exception("用户Id不能为空");
        }
        if(!StringUtils.isEmpty(user.getPassword())){
            String password = user.getPassword();
            user.setPassword(MD5Util.md5(password));
        }
        Integer isSucc = userServiceImpl.updateUser(user);
        return isSucc;
    }
    @RequestMapping("/findUserAll/json")
    @ResponseBody
    public ReturnDatas findUserAll(HttpServletRequest request , User user, PageBean pageBean , Model model )throws Exception{
        ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
        returnObject.setMessage("获取成功");

        List<User> userList = userServiceImpl.findUserAll();
        returnObject.setData(userList);
        return returnObject;
    }

    @RequestMapping("/adfindAll")
    public String adfindAll(HttpServletRequest request , User user, PageBean pageBean , Model model )throws Exception{
        ReturnDatas returnObject = findUserAll(request,user,pageBean,model);
        model.addAttribute("returnObject",returnObject);
        return "admin/Users";
    }

    @RequestMapping("/findUser")
    public User findUser(HttpServletRequest request , Model model , User user)throws Exception{
        user = userServiceImpl.findUser(user.getId());
        return user;
    }

}
