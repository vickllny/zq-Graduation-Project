package com.zq.vm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 描述: 库存入库实体类
 * Time: 2019-02-24 19:00:38
 * @author: zou.qian
 * @version 1.0
 */
@Entity
@Table(name="product_stock_purchase")
public class ProductStockPurchase{
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
	 * 商品进库数量
	 */
	@Column(name="product_purchase_number",length = 11, nullable = true)
	private Integer productPurchaseNumber;
	/**
	 * 商品进库人
	 */
	@Column(name="product_purchase_people",length = 32, nullable = true)
	private String productPurchasePeople;
	/**
	 * 商品进库时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="product_purchase_time",length = 19, nullable = true)
	private Date productPurchaseTime;
	
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
	 * 获取商品进库数量
	 */
	public Integer getProductPurchaseNumber(){
		return productPurchaseNumber;
	}
	/**
	* 设置商品进库数量
	* @param productPurchaseNumber 商品进库数量
	*/
	public void setProductPurchaseNumber(Integer productPurchaseNumber){
		this.productPurchaseNumber=productPurchaseNumber;
	}
	/**
	 * 获取商品进库人
	 */
	public String getProductPurchasePeople(){
		return productPurchasePeople;
	}
	/**
	* 设置商品进库人
	* @param productPurchasePeople 商品进库人
	*/
	public void setProductPurchasePeople(String productPurchasePeople){
		this.productPurchasePeople=productPurchasePeople;
	}
	/**
	 * 获取商品进库时间
	 */
	public Date getProductPurchaseTime(){
		return productPurchaseTime;
	}
	/**
	* 设置商品进库时间
	* @param productPurchaseTime 商品进库时间
	*/
	public void setProductPurchaseTime(Date productPurchaseTime){
		this.productPurchaseTime=productPurchaseTime;
	}
}