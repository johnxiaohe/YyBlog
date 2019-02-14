package com.hxy.blog.controller;

import com.hxy.blog.entity.DicLink;
import com.hxy.blog.entity.User;
import com.hxy.blog.service.DicLinkService;
import com.hxy.blog.service.UserService;
import com.hxy.blog.util.ReturnDatas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class houtaiController {
    @Autowired
    private UserService userService;
    @Autowired
    private DicLinkService dicLinkService;

    @RequestMapping("/goout")
    public String goout(HttpServletRequest request, Model model )throws Exception{

        HttpSession session = request.getSession();
        session.removeAttribute("userId");
        session.removeAttribute("username");
        session.removeAttribute("userheader");
        session.invalidate();
        return "admin/htLogin";
    }

    @RequestMapping("/users")
    public String users(HttpServletRequest request, Model model )throws Exception{
        ReturnDatas returnObject = new ReturnDatas();

        List<User> userList = userService.findUserAll();
        returnObject.setData(userList);
        model.addAttribute("returnObject",returnObject);
        return "admin/Users";
    }

    @RequestMapping("/users/json")
    @ResponseBody
    public ReturnDatas usersJson(HttpServletRequest request, Model model )throws Exception{
        ReturnDatas returnObject = new ReturnDatas();

        List<User> userList = userService.findUserAll();
        returnObject.setCode("0");
        returnObject.setData(userList);
        return returnObject;
    }

    @RequestMapping("/friendlinks")
    public String friendlinks(HttpServletRequest request,Model model)throws Exception{

        ReturnDatas returnObject = friendlinksJson(request,model);
        model.addAttribute("returnObject",returnObject);
        return "admin/friendlinks";
    }

    @RequestMapping("/friendlinks/json")
    @ResponseBody
    public ReturnDatas friendlinksJson(HttpServletRequest request,Model model)throws Exception{
        ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
        List<DicLink> dicLinksList = dicLinkService.findLinkAll();

        returnObject.setData(dicLinksList);

        return  returnObject;

    }



}
