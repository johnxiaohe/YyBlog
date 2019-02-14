package com.hxy.blog.entity;

import java.io.Serializable;

public class DicTag implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String tagName;
    private String tagDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagDesc() {
        return tagDesc;
    }

    public void setTagDesc(String tagDesc) {
        this.tagDesc = tagDesc;
    }

    @Override
    public String toString() {
        return "文章标签表{" +
                "标签表ID=" + getId() +
                ", 标签名称='" + getTagName() + '\'' +
                ", 标签描述='" + getTagDesc() + '\'' +
                '}';
    }
}
