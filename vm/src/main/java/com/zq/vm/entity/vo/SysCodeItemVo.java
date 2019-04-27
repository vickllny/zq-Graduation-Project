package com.zq.vm.entity.vo;

import java.util.List;

import com.zq.vm.entity.SysCodeItem;

/**
 * sysCodeItemVo
 * @author zou.qian
 *
 */
public class SysCodeItemVo {
	private List<SysCodeItem> list;
	private String codeId;
	
	public List<SysCodeItem> getList() {
		return list;
	}
	public void setList(List<SysCodeItem> list) {
		this.list = list;
	}
	public String getCodeId() {
		return codeId;
	}
	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}
}
