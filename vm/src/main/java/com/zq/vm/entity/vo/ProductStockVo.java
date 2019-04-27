package com.zq.vm.entity.vo;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zq.vm.entity.ProductStock;

public class ProductStockVo {
	private String id;
	/**
	 * 商品id
	 */
	private String productId;
	/**
	 * 商品库存数量
	 */
	private Integer productStockNumber;
	/**
	 * 类别  1->入库数量  -1->出库数量
	 */
	private Integer type;
	/**
	 * 商品名称
	 */
	private String productName;
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startTime;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endTime;
	
	public static ProductStockVo build(ProductStock productStock,String productName) {
		ProductStockVo productStockVo = new ProductStockVo();
		BeanUtils.copyProperties(productStock, productStockVo);
		productStockVo.createTime = productStock.getCreateTime();
		productStockVo.productName = productName;
		return productStockVo;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Integer getProductStockNumber() {
		return productStockNumber;
	}
	public void setProductStockNumber(Integer productStockNumber) {
		this.productStockNumber = productStockNumber;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}
