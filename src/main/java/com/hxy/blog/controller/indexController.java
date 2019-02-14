package com.hxy.blog.controller;


import com.hxy.blog.entity.Blog;
import com.hxy.blog.entity.User;
import com.hxy.blog.service.BlogService;
import com.hxy.blog.service.UserService;
import com.hxy.blog.util.MD5Util;
import com.hxy.blog.util.ReturnDatas;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.provider.MD5;
import sun.security.rsa.RSASignature;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class indexController {

    @Autowired
    private UserService userServiceImpl;
    @Autowired
    private BlogService blogService;

    @RequestMapping("/index")
    public String index(HttpServletResponse response , HttpServletRequest request , Model model)throws Exception{

        ReturnDatas returnObject = indexJson(response,request,model);
        model.addAttribute("returnObject",returnObject);
        return "index";
    }

    @RequestMapping("/about")
    public String about(HttpServletResponse response , HttpServletRequest request , Model model)throws Exception{

        ReturnDatas returnObject = aboutJson(response,request,model);
        model.addAttribute("returnObject",returnObject);
        return "about";
    }
    @RequestMapping("/about/json")
    public ReturnDatas aboutJson(HttpServletResponse response , HttpServletRequest request , Model model)throws Exception{
        ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
        returnObject.setMessage("成功获取");

        return returnObject;
    }

    /**
     * 博客首页
     * @param response
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/index/json")
    @ResponseBody
    public ReturnDatas indexJson(HttpServletResponse response , HttpServletRequest request , Model model)throws Exception{
        ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
        returnObject.setMessage("成功获取");

        List<Blog> data = blogService.findBlogIndex();
        returnObject.setData(data);
        return returnObject;
    }

    /**
     * 博客登录 成功跳转首页
     * @param response
     * @param request
     * @param model
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    public String login(HttpServletResponse response , HttpServletRequest request , Model model , User user)throws Exception{
        if(user!=null){
            user.setDark(0);
            user.setLoginTime(new Date());
            User checkUser =userServiceImpl.userLogin(user);
            if(checkUser!=null&&MD5Util.verify(user.getPassword(),checkUser.getPassword())){

                Cookie cookie = new Cookie("header",checkUser.getHeader());
                Cookie cookie1 = new Cookie("nickname",checkUser.getNickname());
                response.addCookie(cookie);
                response.addCookie(cookie1);
                HttpSession session = request.getSession();
                session.setAttribute("user",checkUser);

                ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
                returnObject.setMessage("成功获取");

                List<Blog> data = blogService.findBlogIndex();
                returnObject.setData(data);
                model.addAttribute("returnObject",returnObject);
                return "/index";
            }else{
                model.addAttribute("message","账号或密码不正确");
                return "/login";
            }
        }else{
            return "/login";
        }



    }

    /**
     * 用户注册页面注册成功跳转主页
     * @param response
     * @param request
     * @param model
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping("/register")
    public String register(HttpServletResponse response , HttpServletRequest request , Model model , User user)throws Exception{

        user.setPassword(MD5Util.md5(user.getPassword()));
        user.setDark(0);
        Integer succ = userServiceImpl.saveUser(user);
        if(succ == null){
            //没有保存成功
            model.addAttribute("message","用户注册失败");
            return "/register";
        }
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
        returnObject.setMessage("成功获取");

        List<Blog> data = blogService.findBlogIndex();
        returnObject.setData(data);
        model.addAttribute("returnObject",returnObject);
        return "/index";
    }

    /**
     * 跳转到注册页面
     * @param response
     * @param request
     * @param model
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping("/toregister")
    public String toregister(HttpServletResponse response , HttpServletRequest request , Model model , User user)throws Exception{

        return "/register";
    }

    /**
     * 跳转到登录页面
     * @param response
     * @param request
     * @param model
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping("/tologin")
    public String tologin(HttpServletResponse response , HttpServletRequest request , Model model , User user)throws Exception{
        return "/login";
    }
}
