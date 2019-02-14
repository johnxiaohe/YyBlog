package com.hxy.blog.controller;

import com.hxy.blog.entity.Comment;
import com.hxy.blog.service.CommentService;
import org.hibernate.validator.constraints.CodePointLength;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentServiceImpl;

    @RequestMapping("/saveComment")
    public String saveComment(HttpServletRequest request , HttpServletResponse response , Model model , Comment comment)throws Exception{
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        System.out.println(session.getAttribute("userId"));
        if(session.getAttribute("userId") == null){
            return "/public/login.html";
        }
        return "/index";
    }

    @RequestMapping("/delComment")
    public void delComment(HttpServletRequest request , HttpServletResponse response , Model model , Comment comment)throws Exception{

    }

    @RequestMapping("/findComment")
    public void findComment(HttpServletRequest request , HttpServletResponse response , Model model , Comment comment)throws Exception{

    }

}
