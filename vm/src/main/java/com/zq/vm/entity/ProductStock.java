package com.zq.vm.entity;

import javax.persistence.*;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述: 商品库存实体类
 * Time: 2019-04-13 14:48:40
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
	@GenericGenerator(name="idGenerator", strategy="uuid")
	@GeneratedValue(generator="idGenerator")
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
	 * 类别  1->入库数量  -1->出库数量
	 */
	@Column(name="type",length = 11, nullable = false)
	private Integer type;
	/**
	 * 创建时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="create_time", nullable = false)
	private Date createTime;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}