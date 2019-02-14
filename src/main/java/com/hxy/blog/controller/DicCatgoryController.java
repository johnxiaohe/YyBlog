package com.hxy.blog.controller;

import com.hxy.blog.entity.Blog;
import com.hxy.blog.entity.DicCatgory;
import com.hxy.blog.service.DicCatgoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/catgory")
public class DicCatgoryController {

    @Autowired
    private DicCatgoryService dicCatgoryServiceImpl;

    @RequestMapping("/save")
    public Long saveCatgory(HttpServletRequest request , Model model , DicCatgory dicCatgory)throws Exception{
        dicCatgory.setCatName("随笔");
        dicCatgory.setCatDesc("随便写写");
        //返回主键在对象中，方法返回的是操作记录行数
        Long boo = dicCatgoryServiceImpl.saveCatgory(dicCatgory);
        return dicCatgory.getId();
    }

    /**
     * 返回分类和分类下博客的数量
     * @return
     * @throws Exception
     */
    @RequestMapping("/findCatgoryNum")
    @ResponseBody
    public List<DicCatgory>  findCatgoryNum()throws Exception{
        return dicCatgoryServiceImpl.findCatgoryNum();
    }

    //慎用，分类最好不能删，因为关联有博客文章
    @RequestMapping("/delCatgory")
    public Integer delCatgory(HttpServletRequest request ,Model model ,DicCatgory dicCatgory)throws Exception {
        return dicCatgoryServiceImpl.delCatgory(dicCatgory.getId());
    }

    @RequestMapping("/updateCatgory")
    public Integer updateCatgory(HttpServletRequest request , Model model , DicCatgory dicCatgory)throws Exception{
        dicCatgory.setId(Long.valueOf("5"));
        dicCatgory.setCatDesc("第五个分类");
        dicCatgory.setCatName("第五");
        return dicCatgoryServiceImpl.updateCatgory(dicCatgory);
    }

    @RequestMapping("/findCatgory")
    public List<DicCatgory> findCatgory(HttpServletRequest request , Model model )throws Exception{
        return dicCatgoryServiceImpl.findCatgory();
    }


}
