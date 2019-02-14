package com.hxy.blog.entity;

import com.hxy.blog.util.PageBean;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nickname;

    private String account;

    private String password;

    private Date loginTime;

    private Integer dark;

    private Date darkTime;

    private String header;

    private String question;

    private String answer;
    private PageBean pageBean;

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getDark() {
        return dark;
    }

    public void setDark(Integer dark) {
        this.dark = dark;
    }

    public Date getDarkTime() {
        return darkTime;
    }

    public void setDarkTime(Date darkTime) {
        this.darkTime = darkTime;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return "用户表{" +
                "用户表ID=" + getId() +
                ", 用户昵称='" + getNickname() + '\'' +
                ", 用户账号='" + getAccount() + '\'' +
                ", 用户密码='" + getPassword() + '\'' +
                ", 注册时间=" + getLoginTime() +
                ", 是否拉黑=" + getDark() +
                ", 拉黑时间=" + getDarkTime() +
                ", 用户头像='" + getHeader() + '\'' +
                ", 密保问题='" + getQuestion() + '\'' +
                ", 密保答案='" + getAnswer() + '\'' +
                '}';
    }
}
