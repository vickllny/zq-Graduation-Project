package com.zq.vm.utils;

import java.io.Serializable;
import java.util.List;

/**
 * layui 表格分页对象
 */
public class Pager implements Serializable {
    private int code = 0;
    private String msg ;
    private boolean page = true;
    private List<? extends Object> data;
    private long count;

    public Pager(List<? extends Object> data, long count) {
        this.data = data;
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isPage() {
        return page;
    }

    public void setPage(boolean page) {
        this.page = page;
    }

    public List<? extends Object> getData() {
        return data;
    }

    public void setData(List<? extends Object> data) {
        this.data = data;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
