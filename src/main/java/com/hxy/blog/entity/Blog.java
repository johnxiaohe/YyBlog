package com.hxy.blog.entity;

import com.hxy.blog.util.PageBean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Blog implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    private Long userId;

    private String title;

    private String mdContent;

    private String content;

    private Date createTime;

    private Long lookNum;

    private Long likeNum;

    private Long commentNum;

    private Date modifyTime;

    private String tagIds;

    private Long categoryId;

    private String descr;

    private String blogHeader;

    private String nickname;

    private String catName;

    private PageBean pageBean;

    private List<Comment> comment;

    public String getNickname() {
        return nickname;
    }


    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getLookNum() {
        return lookNum;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public void setLookNum(Long lookNum) {
        this.lookNum = lookNum;
    }

    public Long getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Long likeNum) {
        this.likeNum = likeNum;
    }

    public Long getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Long commentNum) {
        this.commentNum = commentNum;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getBlogHeader() {
        return blogHeader;
    }

    public void setBlogHeader(String blogHeader) {
        this.blogHeader = blogHeader;
    }

    public String getMdContent() {
        return mdContent;
    }

    public void setMdContent(String mdContent) {
        this.mdContent = mdContent;
    }

    @Override
    public String toString() {
        return "{" +
                "博客ID=" + getId() +
                ", 用户ID=" + getUserId() +
                ", 博客标题='" + getTitle() + '\'' +
                ", 博客内容='" + getContent() + '\'' +
                ", 发表时间=" + getCreateTime() +
                ", 浏览量=" + getLookNum() +
                ", 点赞量=" + getLikeNum() +
                ", 评论量=" + getCommentNum() +
                ", 最后修改时间=" + getModifyTime() +
                ", 博客标签Ids='" + getTagIds() + '\'' +
                ", 分类ID=" + getTagIds() +
                ", 博客图标='" + getBlogHeader() + '\'' +
                ", md编辑器内容='" + getMdContent() + '\'' +
                '}';
    }
}
