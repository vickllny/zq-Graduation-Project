/**
 * Package:com.wisesoft.dev.tools.codegen
 * Classname: Tree.java
 * Copyright: 川大智胜系统集成公司 
 * Date: 2018年5月14日
 * Time: 下午3:26:34
 * @author li.lin
 * @version 1.0
 */ 

package com.zq.codegen;

/**
 * Copyright: 川大智胜系统集成公司 
 * Date: 2018年5月14日
 * Time: 下午3:26:34
 * @author li.lin
 * @version 1.0
 */

public class Tree {
	/**
	 * id
	 */
	private String id;
	/**
	 * 父id
	 */
	private String pId;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 列表对应字段
	 */
	private String field;
	/**
	 * 查询的sql
	 */
	private String sql;
	/**
	 * 表单下拉选择url  ex:  /event/treeSelectJson.dhtml
	 */
	private String showUrl;
	
	public Tree() {
		super();
	}

	public Tree(String id, String pId, String name, String field) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.field = field;
	}

	public Tree(String id, String pId, String name, String field, String sql) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.field = field;
		this.sql = sql;
	}

	public String getId() {
		return id;
	}
	

	public void setId(String id) {
		this.id = id;
	}
	

	public String getpId() {
		return pId;
	}
	

	public void setpId(String pId) {
		this.pId = pId;
	}
	

	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	

	public String getField() {
		return field;
	}
	

	public void setField(String field) {
		this.field = field;
	}

	public String getSql() {
		return sql;
	}
	

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getShowUrl() {
		return showUrl;
	}
	

	public void setShowUrl(String showUrl) {
		this.showUrl = showUrl;
	}
	
	
	
	
	
}
