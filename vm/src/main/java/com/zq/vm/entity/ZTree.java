package com.zq.vm.entity;

public class ZTree {

    public static final String DEFAULT_PID = "#";

    private String id;
    private String name;
    private String pId;
    private boolean checked;

    public ZTree(String id, String name, String pId) {
        this.id = id;
        this.name = name;
        this.pId = pId;
    }
    
    public ZTree(String id, String name, String pId,boolean checked) {
        this.id = id;
        this.name = name;
        this.pId = pId;
        this.checked = checked;
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

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}