package com.hxy.blog.entity;

import java.io.Serializable;

public class UserIp implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ipInfo;

    private Long userId;

    public String getIpInfo() {
        return ipInfo;
    }

    public void setIpInfo(String ipInfo) {
        this.ipInfo = ipInfo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "用户注册IP地址{" +
                "注册该博客='" + getIpInfo() + '\'' +
                ", 用户表ID=" + getUserId() +
                '}';
    }
}
