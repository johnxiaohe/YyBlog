package com.hxy.blog.dao;

import com.hxy.blog.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BlogMapper {

    Long saveBlog(Blog blog);

    Blog findBlogById(Long id);

    Integer updateBlogById(Blog blog);
    //查找该分类下的所有博客
    List<Blog> findBlogByCategoryId(Blog blog);
    //查找该标签下的所有博客
    List<Blog> findBlogByTagId(Blog blog);
        //select * from h_blog where FIND_IN_SET('3',tagIds);
        //select * from h_blog where tagIds like '%3%';
    //查找博客标题 模糊查询
    List<Blog> findBlogByTitle(Blog blog);
    //点开博客 并附带博客的评论
    Blog findBlogAndComment( Long id);
    //首页博客列表显示前二十个
    List<Blog> findBlogIndex();

    List<Blog> findBlogHt();

    Integer delBlog(@Param(value = "id")Integer id);
}
