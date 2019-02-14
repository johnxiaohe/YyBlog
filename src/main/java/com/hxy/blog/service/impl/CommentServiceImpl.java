package com.hxy.blog.service.impl;

import com.hxy.blog.dao.CommentMapper;
import com.hxy.blog.entity.Comment;
import com.hxy.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Integer saveComment(Comment comment) {
        return commentMapper.saveComment(comment);
    }

    @Override
    public Integer delComment(Long id) {
        return commentMapper.delComment(id);
    }

    @Override
    public Comment findComment(Long id) {
        return commentMapper.findComment(id);
    }
}
