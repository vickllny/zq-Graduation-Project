package com.zq.vm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 描述: 套餐商品信息表实体类
 * Time: 2019-04-21 17:12:30
 * @author: zou.qian
 * @version 1.0
 */
@Entity
@Table(name="set_meal_information_product")
public class SetMealInformationProduct{
	/**
	 * 主键
	 */
	@Id
	@GenericGenerator(name="idGenerator", strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	private String id;
	/**
	 * 套餐id
	 */
	@Column(name="set_meal_information_id",length = 32, nullable = false)
	private String setMealInformationId;
	/**
	 * 商品id
	 */
	@Column(name="product_id",length = 32, nullable = false)
	private String productId;
	/**
	 * 商品数量
	 */
	@Column(name="count",length = 11, nullable = true)
	private Integer count;
	/**
	 * 类别 1->商品  2->服务
	 */
	@Column(name="type",length = 3, nullable = true)
	private String type;
	
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
	 * 获取套餐id
	 */
	public String getSetMealInformationId(){
		return setMealInformationId;
	}
	/**
	* 设置套餐id
	* @param setMealInformationId 套餐id
	*/
	public void setSetMealInformationId(String setMealInformationId){
		this.setMealInformationId=setMealInformationId;
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
	 * 获取商品数量
	 */
	public Integer getCount(){
		return count;
	}
	/**
	* 设置商品数量
	* @param count 商品数量
	*/
	public void setCount(Integer count){
		this.count=count;
	}
	/**
	 * 获取类别 1->商品  2->服务
	 */
	public String getType(){
		return type;
	}
	/**
	* 设置类别 1->商品  2->服务
	* @param type 类别 1->商品  2->服务
	*/
	public void setType(String type){
		this.type=type;
	}
}