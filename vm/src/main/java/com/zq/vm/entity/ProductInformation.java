package com.zq.vm.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 描述: 余额信息实体类
 * Time: 2019-02-24 18:53:33
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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private String id;
	/**
	 * 商品ID
	 */
	@Column(name="product_id",length = 32, nullable = false)
	private String productId;
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
	 * 获取商品ID
	 */
	public String getProductId(){
		return productId;
	}
	/**
	* 设置商品ID
	* @param productId 商品ID
	*/
	public void setProductId(String productId){
		this.productId=productId;
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
}