package com.zq.vm.entity;

import javax.persistence.*;

/**
 * 描述: 余额信息实体类
 * Time: 2019-02-24 18:55:51
 * @author: zou.qian
 * @version 1.0
 */
@Entity
@Table(name="product_stock")
public class ProductStock{
	/**
	 * 主键
	 */
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private String id;
	/**
	 * 商品id
	 */
	@Column(name="product_id",length = 32, nullable = false)
	private String productId;
	/**
	 * 商品库存数量
	 */
	@Column(name="product_stock_number",length = 11, nullable = true)
	private Integer productStockNumber;
	
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
	 * 获取商品id
	 */
	public String getProductId(){
		return productId;
	}
	/**
	* 设置商品id
	* @param productId 商品id
	*/
	public void setProductId(String productId){
		this.productId=productId;
	}
	/**
	 * 获取商品库存数量
	 */
	public Integer getProductStockNumber(){
		return productStockNumber;
	}
	/**
	* 设置商品库存数量
	* @param productStockNumber 商品库存数量
	*/
	public void setProductStockNumber(Integer productStockNumber){
		this.productStockNumber=productStockNumber;
	}
}