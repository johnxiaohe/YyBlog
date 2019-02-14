package com.hxy.blog.controller;

import com.hxy.blog.entity.Blog;
import com.hxy.blog.entity.User;
import com.hxy.blog.service.BlogService;
import com.hxy.blog.service.UserService;
import com.hxy.blog.util.PageBean;
import com.hxy.blog.util.ReturnDatas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogServiceImpl;
    @Autowired
    private UserService userService;

    /**
     * 发表博客
     * @param request
     * @param blog
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/addBlog")
    public String save(HttpServletRequest request , Blog blog, Model model)throws Exception{
        blog.setCreateTime(new Date());
        blogServiceImpl.saveBlog(blog);
        return "admin/writerblog";
    }

    /**
     * 跳转到书写或者修改博客页面
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/toWrite")
    public String toWrite(HttpServletRequest request , Blog blog, Model model)throws Exception{
        model.addAttribute("blog",blog);
        return "blog/writerblog";
    }


    //没有评论的博客详情
    @RequestMapping("/findBlogById")
    public String findBlogOne(HttpServletRequest request , Blog blog, Model model)throws Exception{
        ReturnDatas returnObject = findBlogById( request ,  blog,  model);
        model.addAttribute(returnObject);
        return "/single";
    }

    /**
     * 通过id查找博客
     * @param request
     * @param blog
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/findBlogById/json")
    @ResponseBody
    public ReturnDatas findBlogById(HttpServletRequest request , Blog blog, Model model)throws Exception{
        ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
        returnObject.setMessage("查询成功");

        Blog data = blogServiceImpl.findBlogById(blog.getId());

        returnObject.setData(data);
        return returnObject;
    }


    @RequestMapping("/updateBlogById")
    public String updateBlog(HttpServletRequest request , Blog blog , Model model)throws Exception{
        ReturnDatas returnObject = updateBlogById( request ,  blog ,  model);
        model.addAttribute(returnObject);
        return "/blog/blogList";
    }

    /**
     * 通过id修改博客  修改内容 点赞 评论 浏览 分类 标签
     * @param request
     * @param blog
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateBlogById/json")
    @ResponseBody
    public ReturnDatas updateBlogById(HttpServletRequest request , Blog blog , Model model)throws Exception{
        ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
        returnObject.setMessage("更新成功");

        blog.setModifyTime(new Date());
        blogServiceImpl.updateBlogById(blog);

        return returnObject;
    }

    @RequestMapping("/findBlogByCategoryId")
    public String blogAndCategory(HttpServletRequest request ,PageBean pageBean, Blog blog , Model model)throws Exception{
        ReturnDatas returnObject = findBlogByCategoryId(request,pageBean,blog,model);
        model.addAttribute("returnObject",returnObject);
        return "blog";
    }

    /**
     * 通过分类ID查找博客
     * @param request
     * @param blog
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/findBlogByCategoryId/json")
    @ResponseBody
    public ReturnDatas findBlogByCategoryId(HttpServletRequest request ,PageBean pageBean, Blog blog , Model model)throws Exception{
        ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
        returnObject.setMessage("查询成功");
        if(pageBean != null){
            //获取到总记录数
            List<Blog> totalBlog = blogServiceImpl.findBlogByCategoryId(blog);
            Integer count = totalBlog.size();
            pageBean.setTotalCount(count);
//            pageBean.setPageIndex((pageBean.getPageIndex()-1)*pageBean.getPageSize());
            blog.setPageBean(pageBean);
        }
        List<Blog> data = blogServiceImpl.findBlogByCategoryId(blog);
        if(data.size() <=0){
            data = null;
        }
        returnObject.setQueryBean(blog);
        returnObject.setPageBean(pageBean);
        returnObject.setData(data);

        return returnObject;
    }

    @RequestMapping("/findBlogByTagId")
    public String blogAndTag(HttpServletRequest request ,Blog blog,PageBean pageBean, Model model)throws Exception{
        ReturnDatas returnObject = findBlogByTagId(request,blog,pageBean,model);
        model.addAttribute(returnObject);
        return "/blog/tagBlog";
    }

    /**
     * 通过标签ID查找博客
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/findBlogByTagId/json")
    @ResponseBody
    public ReturnDatas findBlogByTagId(HttpServletRequest request ,Blog blog,PageBean pageBean, Model model)throws Exception{
        ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
        returnObject.setMessage("查询成功");
        if(pageBean != null){
            //获取到总记录数
            List<Blog> totalBlog = blogServiceImpl.findBlogByTagId(blog);
            Integer count = totalBlog.size();
            pageBean.setTotalCount(count);
            blog.setPageBean(pageBean);
        }
        List<Blog> data = blogServiceImpl.findBlogByTagId(blog);

        returnObject.setQueryBean(blog);
        returnObject.setPageBean(pageBean);
        returnObject.setData(data);

        return returnObject;
    }

    @RequestMapping("/findBlogByTitle")
    public String blogAndTitle(HttpServletRequest request ,Blog blog,PageBean pageBean, Model model)throws Exception{
        ReturnDatas returnObject = findBlogByTitle(request,blog,pageBean,model);
        model.addAttribute(returnObject);
        return "/blog/titleBlog";
    }

    /**
     * 通过标题查找博客
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/findBlogByTitle/json")
    @ResponseBody
    public ReturnDatas findBlogByTitle(HttpServletRequest request ,Blog blog,PageBean pageBean, Model model)throws Exception{
        ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
        returnObject.setMessage("查询成功");
        if(pageBean != null){
            //获取到总记录数
            List<Blog> totalBlog = blogServiceImpl.findBlogByTitle(blog);
            Integer count = totalBlog.size();
            pageBean.setTotalCount(count);
            blog.setPageBean(pageBean);
        }
        List<Blog> data = blogServiceImpl.findBlogByTitle(blog);

        returnObject.setQueryBean(blog);
        returnObject.setPageBean(pageBean);
        returnObject.setData(data);

        return returnObject;
    }

    //查看博客详情
    @RequestMapping("/findBlogAndComment")
    public String findBlogAndComment(HttpServletRequest request , Model model, Blog blog)throws Exception{
        ReturnDatas returnObject = queryBlogById(request,model,blog);
        model.addAttribute("returnObject",returnObject);
        return "single";
    }

    @RequestMapping("/findBlogAndComment/json")
    @ResponseBody
    public ReturnDatas queryBlogById(HttpServletRequest request , Model model, Blog blog)throws Exception{

        ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
        returnObject.setMessage("查询成功");

        Blog data = blogServiceImpl.findBlogAndComment(blog.getId());

        returnObject.setData(data);
        return returnObject;
    }


}
