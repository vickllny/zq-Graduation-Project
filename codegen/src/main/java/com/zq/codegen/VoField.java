package com.zq.codegen;

public class VoField {
	private String type;
	private String field;
	private String comment;
	
	public VoField(String type, String field,String comment) {
		super();
		this.type = type;
		this.field = field;
		this.comment = comment;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
