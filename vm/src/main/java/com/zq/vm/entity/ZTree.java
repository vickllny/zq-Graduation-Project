package com.zq.vm.entity;

import java.util.List;

public class ZTree {

    public static final String DEFAULT_PID = "#";

    private String id;
    private String name;
    private String pId;
    private boolean isParent;
    private List<ZTree> children;

    public ZTree(String id, String name, String pId) {
        this.id = id;
        this.name = name;
        this.pId = pId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public List<ZTree> getChildren() {
        return children;
    }

    public void setChildren(List<ZTree> children) {
        this.children = children;
    }

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }
}