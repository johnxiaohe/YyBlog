package com.hxy.blog.util;


import java.io.Serializable;
import java.util.Map;

/**
 * 返回对象的封装
 * @author caomei
 *
 */
@SuppressWarnings("serial")
public class ReturnDatas implements Serializable{
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";
    public static final String WARNING = "warning";
    public static final String LOGIN = "login";
    public static final String REGISTER = "register";
    private String statusCode="200";
    private String status;
    private String message;
    private String code;
    private Object data;
    private Integer palceCount;
    @SuppressWarnings("rawtypes")
    private Map map;
    private PageBean pageBean;
    private String sum;
    private Object queryBean;

    public ReturnDatas() {

    }

    public static ReturnDatas getSuccessReturnDatas() {
        return new ReturnDatas(ReturnDatas.SUCCESS);
    }
    public static ReturnDatas getErrorReturnDatas() {
        return new ReturnDatas(ReturnDatas.ERROR);
    }
    public static ReturnDatas getWarningReturnDatas() {
        return new ReturnDatas(ReturnDatas.WARNING);
    }


    public ReturnDatas(String status) {
        this.status = status;
    }

    public ReturnDatas(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getPalceCount() {
        return palceCount;
    }

    public void setPalceCount(Integer palceCount) {
        this.palceCount = palceCount;
    }

    public ReturnDatas(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object obj) {
        this.data = obj;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean page) {
        this.pageBean = page;
    }

    @SuppressWarnings("rawtypes")
    public Map getMap() {
        return map;
    }

    @SuppressWarnings("rawtypes")
    public void setMap(Map map) {
        this.map = map;
    }

    public Object getQueryBean() {
        return queryBean;
    }

    public void setQueryBean(Object queryBean) {
        this.queryBean = queryBean;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}

