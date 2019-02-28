package com.hxy.blog.entity;

import com.hxy.blog.util.PageBean;

import java.io.Serializable;
import java.util.Date;

public class DicLink implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String logo;
    private String friendLink;
    private String friendName;
    private String linkDesc;
    private Date createTime;
    private PageBean pageBean;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getFriendLink() {
        return friendLink;
    }

    public void setFriendLink(String friendLink) {
        this.friendLink = friendLink;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getLinkDesc() {
        return linkDesc;
    }

    public void setLinkDesc(String linkDesc) {
        this.linkDesc = linkDesc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    @Override
    public String toString() {
        return "友情链接表{" +
                "友链表ID=" + getId() +
                ", 友链Logo='" + getLogo() + '\'' +
                ", 友情链接='" + getFriendLink() + '\'' +
                ", 友链名称='" + getFriendName() + '\'' +
                ", 友链描述='" + getLinkDesc() + '\'' +
                ", 添加时间=" + getCreateTime() +
                '}';
    }
}
