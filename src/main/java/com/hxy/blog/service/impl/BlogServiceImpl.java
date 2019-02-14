package com.hxy.blog.service.impl;

import com.hxy.blog.dao.BlogMapper;
import com.hxy.blog.entity.Blog;
import com.hxy.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public Long saveBlog(Blog blog) throws Exception {
        return blogMapper.saveBlog(blog);
    }

    @Override
    public Blog findBlogById(Long id)throws Exception{
        return blogMapper.findBlogById(id);
    }

    @Override
    public Integer updateBlogById(Blog blog)throws Exception{
        return blogMapper.updateBlogById(blog);
    }

    @Override
    public List<Blog> findBlogByCategoryId(Blog blog) throws Exception {
        return blogMapper.findBlogByCategoryId(blog);
    }

    @Override
    public List<Blog> findBlogByTagId(Blog blog)throws Exception{
        return blogMapper.findBlogByTagId(blog);
    }

    @Override
    public List<Blog> findBlogByTitle(Blog blog) throws Exception {
        return blogMapper.findBlogByTitle(blog);
    }

    @Override
    public Blog findBlogAndComment(Long id) {
        return blogMapper.findBlogAndComment(id);
    }

    @Override
    public List<Blog> findBlogIndex() {
        return blogMapper.findBlogIndex();
    }
}
