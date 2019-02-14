package com.hxy.blog.controller;


import com.hxy.blog.entity.Blog;
import com.hxy.blog.entity.DicTag;
import com.hxy.blog.service.DicTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/dictag")
public class DicTagController {

    @Autowired
    private DicTagService dicTagServiceImpl;

    @RequestMapping("/saveTag")
    public void saveTag(HttpServletRequest request , HttpServletResponse response , Model model , DicTag dicTag)throws Exception{

    }

    @RequestMapping("/delTag")
    public void delTag(HttpServletRequest request , HttpServletResponse response , Model model , DicTag dicTag)throws Exception{

    }

    @RequestMapping("/updateTag")
    public void updateTag(HttpServletRequest request , HttpServletResponse response , Model model , DicTag dicTag)throws Exception{

    }

    @RequestMapping("/findTagAll")
    public void findTagAll(HttpServletRequest request , HttpServletResponse response , Model model , DicTag dicTag)throws Exception{

    }

    @RequestMapping("/findTagByTags")
    @ResponseBody
    public List<DicTag> findTagByTags(HttpServletRequest request , HttpServletResponse response , Model model , Blog blog)throws Exception{
            if(blog.getTagIds() != null){
                String[] tags = blog.getTagIds().split(",");
                List<DicTag> data = dicTagServiceImpl.findTagByTags(tags);
               return  data;
            }
            return null;
    }

}
