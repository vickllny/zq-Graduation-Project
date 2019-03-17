package com.zq.codegen;

import org.apache.commons.lang.StringUtils;

/**
 * 所属类别: 数据类<br/> 用途:字段信息<br/> Author:<a href="mailto:hxfein@126.com">黄飞</a>
 * <br/> Date: 2011-6-17 <br/> Time: 下午02:50:45 <br/> Version: 1.0.2 <br/>
 */
public class Column {
	private String dbName;
	private String logicName;
	private boolean nullable;
	private String dbType;
	private String fieldName;
	private String javaType;
	private int length;
	private boolean isPk;

	public boolean isPk() {
		return isPk;
	}

	public void setPk(boolean isPk) {
		this.isPk = isPk;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getLogicName() {
		return logicName;
	}

	public void setLogicName(String logicName) {
		this.logicName = logicName;
	}

	public boolean isNullable() {
		return nullable;
	}

	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getCapitalizeName() {
		return StringUtils.capitalize(this.fieldName);
	}

	/**
	 * 获取页面验证表达式
	 * 
	 * @return
	 */
	public String getVldExpr() {
		StringBuffer sb = new StringBuffer("{");
		boolean hasExpr = false;
		if (this.nullable == false) {
			sb.append("required:true");
			hasExpr = true;
		}
		sb.append("}");
		if (hasExpr) {
			return sb.toString();
		}
		return null;
	}
}
