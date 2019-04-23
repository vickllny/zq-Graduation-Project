package com.zq.vm.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 描述: 商品信息实体类
 * Time: 2019-04-13 15:38:35
 * @author: zou.qian
 * @version 1.0
 */
@Entity
@Table(name="product_information")
public class ProductInformation{
	/**
	 * 主键
	 */
	@Id
	@GenericGenerator(name="idGenerator", strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	private String id;
	/**
	 * 商品名称
	 */
	@Column(name="name",length = 255, nullable = true)
	private String name;
	/**
	 * 商品进价
	 */
	@Column(name="purchase_price",length = 10, nullable = true)
	private BigDecimal purchasePrice;
	/**
	 * 商品卖价
	 */
	@Column(name="selling_price",length = 10, nullable = true)
	private BigDecimal sellingPrice;
	/**
	 * 单位
	 */
	@Column(name="unit",length = 255, nullable = true)
	private String unit;
	/**
	 * 数量
	 */
	@Column(name="quantity",length = 255, nullable = true)
	private Integer quantity = 0;
	
	/**
	 * 获取主键
	 */
	public String getId(){
		return id;
	}
	/**
	* 设置主键
	* @param id 主键
	*/
	public void setId(String id){
		this.id=id;
	}
	/**
	 * 获取商品名称
	 */
	public String getName(){
		return name;
	}
	/**
	* 设置商品名称
	* @param name 商品名称
	*/
	public void setName(String name){
		this.name=name;
	}
	/**
	 * 获取商品进价
	 */
	public BigDecimal getPurchasePrice(){
		return purchasePrice;
	}
	/**
	* 设置商品进价
	* @param purchasePrice 商品进价
	*/
	public void setPurchasePrice(BigDecimal purchasePrice){
		this.purchasePrice=purchasePrice;
	}
	/**
	 * 获取商品卖价
	 */
	public BigDecimal getSellingPrice(){
		return sellingPrice;
	}
	/**
	* 设置商品卖价
	* @param sellingPrice 商品卖价
	*/
	public void setSellingPrice(BigDecimal sellingPrice){
		this.sellingPrice=sellingPrice;
	}
	/**
	 * 获取单位
	 */
	public String getUnit(){
		return unit;
	}
	/**
	* 设置单位
	* @param unit 单位
	*/
	public void setUnit(String unit){
		this.unit=unit;
	}
	/**
	 * 获取数量
	 */
	public Integer getQuantity(){
		return quantity;
	}
	/**
	* 设置数量
	* @param quantity 数量
	*/
	public void setQuantity(Integer quantity){
		this.quantity=quantity;
	}
	public void addQuantity(Integer productStockNumber) {
		this.quantity += productStockNumber;
	}
}