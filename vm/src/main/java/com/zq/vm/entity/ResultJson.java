package com.zq.vm.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ResultJson implements Serializable {

    public static final String ERROR = "error";
    public static final String SUCCESS = "success";

    /**
     * 状态
     */
    private String status;
    /**
     * 消息
     */
    private String message;
    /**
     * data
     */
    private Object data;

    public ResultJson(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResultJson(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
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

    public void setData(Object data) {
        this.data = data;
    }
}
