package com.hxy.blog.service;


import com.hxy.blog.entity.Comment;

public interface CommentService {

    Integer saveComment(Comment comment);

    Integer delComment(Long id);

    Comment findComment(Long id);

}
