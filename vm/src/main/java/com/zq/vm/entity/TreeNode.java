package com.zq.vm.entity;

public interface TreeNode {
	default String getNodeId() {return "";}
	default String getNodeName() {return "";}
	default String getNodePid() {return "";}
	default boolean getNodechecked() {return false;}
}
