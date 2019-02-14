package com.hxy.blog.dao;

import com.hxy.blog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 实现评论的存取 不能修改评论
 */
@Mapper
public interface CommentMapper {

    Integer saveComment(Comment comment);
    Integer delComment(Long id);
    //取的时候顺便取出用户的头像和用户的昵称
    Comment findComment(Long id);


}
