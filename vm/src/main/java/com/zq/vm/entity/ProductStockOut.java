package com.zq.vm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 描述: 余额信息实体类
 * Time: 2019-02-24 18:58:30
 * @author: zou.qian
 * @version 1.0
 */
@Entity
@Table(name="product_stock_out")
public class ProductStockOut{
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
	 * 商品出库数量
	 */
	@Column(name="product_out_number",length = 11, nullable = true)
	private Integer productOutNumber;
	/**
	 * 商品出库人
	 */
	@Column(name="product_out_people",length = 32, nullable = true)
	private String productOutPeople;
	/**
	 * 商品出库时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="product_out_time",length = 19, nullable = true)
	private Date productOutTime;
	
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
	 * 获取商品出库数量
	 */
	public Integer getProductOutNumber(){
		return productOutNumber;
	}
	/**
	* 设置商品出库数量
	* @param productOutNumber 商品出库数量
	*/
	public void setProductOutNumber(Integer productOutNumber){
		this.productOutNumber=productOutNumber;
	}
	/**
	 * 获取商品出库人
	 */
	public String getProductOutPeople(){
		return productOutPeople;
	}
	/**
	* 设置商品出库人
	* @param productOutPeople 商品出库人
	*/
	public void setProductOutPeople(String productOutPeople){
		this.productOutPeople=productOutPeople;
	}
	/**
	 * 获取商品出库时间
	 */
	public Date getProductOutTime(){
		return productOutTime;
	}
	/**
	* 设置商品出库时间
	* @param productOutTime 商品出库时间
	*/
	public void setProductOutTime(Date productOutTime){
		this.productOutTime=productOutTime;
	}
}