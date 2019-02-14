package com.hxy.blog.service;

import com.hxy.blog.entity.Blog;

import java.util.List;

public interface BlogService {

    Long saveBlog(Blog blog)throws Exception;

    Blog findBlogById(Long id)throws Exception;

    Integer updateBlogById(Blog blog)throws Exception;

    List<Blog> findBlogByCategoryId(Blog blog)throws Exception;

    List<Blog> findBlogByTagId(Blog blog)throws Exception;

    List<Blog> findBlogByTitle(Blog blog)throws Exception;

    Blog findBlogAndComment(Long id);

    List<Blog> findBlogIndex();

}
