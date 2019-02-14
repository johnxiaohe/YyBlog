package com.hxy.blog.entity;

import java.io.Serializable;

public class DicCatgory implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String catName;

    private String catDesc;

    private Long catParentId;

    private Integer num;

    public void setNum(Integer num){
        this.num = num;
    }

    public Integer getNum(){
        return num;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatDesc() {
        return catDesc;
    }

    public void setCatDesc(String catDesc) {
        this.catDesc = catDesc;
    }

    public Long getCatParentId() {
        return catParentId;
    }

    public void setCatParentId(Long catParentId) {
        this.catParentId = catParentId;
    }

    @Override
    public String toString() {
        return "博客分类表{" +
                "分类表ID=" + getId() +
                ", 分类名称='" + getCatName() + '\'' +
                ", 分类描述='" + getCatDesc() + '\'' +
                ", 父分类ID=" + getCatParentId() +
                '}';
    }
}
