package com.zq.vm.entity.vo;

import com.zq.vm.entity.TreeNode;

public class MenuVo implements TreeNode{
	private String id;
	private String name;
	private String pid;
	
	@Override
	public String getNodeId() {
		return this.id;
	}
	@Override
	public String getNodeName() {
		return this.name;
	}
	@Override
	public String getNodePid() {
		return this.pid;
	}
	@Override
	public boolean getNodechecked() {
		return TreeNode.super.getNodechecked();
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
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	
}
