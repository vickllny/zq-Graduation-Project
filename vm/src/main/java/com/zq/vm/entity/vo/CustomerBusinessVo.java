package com.zq.vm.entity.vo;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomerBusinessVo {

	/**
	 * 主键
	 */
	private String id;
	/**
	 * 名字
	 */
	private String name;
	
	private String customer_Id;
	
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date purchaseTime;
	
	private String productId;
	
	private String productName;
	
	private String type;
	
	private BigDecimal amount;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getPurchaseTime() {
		return purchaseTime;
	}
	public void setPurchaseTime(Date purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getCustomer_Id() {
		return customer_Id;
	}
	public void setCustomer_Id(String customer_Id) {
		this.customer_Id = customer_Id;
	}
	public static CustomerBusinessVo build(Object[] array) {
		CustomerBusinessVo vo = new CustomerBusinessVo();
		vo.setId(String.valueOf(array[0]));
		vo.setName(String.valueOf(array[1]));
		vo.setCustomer_Id(String.valueOf(array[2]));
		vo.setPurchaseTime((Date)array[3]);
		vo.setProductId(String.valueOf(array[4]));
		vo.setProductName(String.valueOf(array[5]));
		vo.setType(String.valueOf(array[6]));
		vo.setAmount((BigDecimal)array[7]);
		return vo;
	}
	public static CustomerBusinessVo buildRank(Object[] array) {
		CustomerBusinessVo vo = new CustomerBusinessVo();
		vo.setId(String.valueOf(array[0]));
		vo.setName(String.valueOf(array[1]));
		vo.setAmount((BigDecimal)array[2]);
		return vo;
	}
	
}
