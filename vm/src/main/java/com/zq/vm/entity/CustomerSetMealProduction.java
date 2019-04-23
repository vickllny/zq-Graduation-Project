package com.zq.vm.entity;

import javax.persistence.*;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 描述: 会员套餐商品关系表实体类
 * Time: 2019-04-23 22:04:24
 * @author: zou.qian
 * @version 1.0
 */
@Entity
@Table(name="customer_set_meal_production")
public class CustomerSetMealProduction{
	/**
	 * 主键
	 */
	@Id
	@GenericGenerator(name="idGenerator", strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	private String id;
	/**
	 * 会员id
	 */
	@Column(name="customer_id",length = 36, nullable = false)
	private String customerId;
	/**
	 * 套餐id
	 */
	@Column(name="set_meal_id",length = 36, nullable = false)
	private String setMealId;
	/**
	 * 
	 */
	@Column(name="customer_set_meal_id",length = 36, nullable = false)
	private String customerSetMealId;
	/**
	 * 
	 */
	@Column(name="product_id",length = 36, nullable = false)
	private String productId;
	/**
	 * 1->商品  2->服务
	 */
	@Column(name="type",length = 5, nullable = false)
	private String type;
	/**
	 * 数量
	 */
	@Column(name="count",length = 11, nullable = false)
	private Integer count;
	
	public CustomerSetMealProduction() {}
	
	public CustomerSetMealProduction(String customerId, String setMealId, String customerSetMealId,
			String productId, String type, Integer count) {
		this.customerId = customerId;
		this.setMealId = setMealId;
		this.customerSetMealId = customerSetMealId;
		this.productId = productId;
		this.type = type;
		this.count = count;
	}



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
	 * 获取会员id
	 */
	public String getCustomerId(){
		return customerId;
	}
	/**
	* 设置会员id
	* @param customerId 会员id
	*/
	public void setCustomerId(String customerId){
		this.customerId=customerId;
	}
	/**
	 * 获取套餐id
	 */
	public String getSetMealId(){
		return setMealId;
	}
	/**
	* 设置套餐id
	* @param setMealId 套餐id
	*/
	public void setSetMealId(String setMealId){
		this.setMealId=setMealId;
	}
	/**
	 * 获取
	 */
	public String getCustomerSetMealId(){
		return customerSetMealId;
	}
	/**
	* 设置
	* @param customerSetMealId 
	*/
	public void setCustomerSetMealId(String customerSetMealId){
		this.customerSetMealId=customerSetMealId;
	}
	/**
	 * 获取
	 */
	public String getProductId(){
		return productId;
	}
	/**
	* 设置
	* @param productId 
	*/
	public void setProductId(String productId){
		this.productId=productId;
	}
	/**
	 * 获取1->商品  2->服务
	 */
	public String getType(){
		return type;
	}
	/**
	* 设置1->商品  2->服务
	* @param type 1->商品  2->服务
	*/
	public void setType(String type){
		this.type=type;
	}
	/**
	 * 获取数量
	 */
	public Integer getCount(){
		return count;
	}
	/**
	* 设置数量
	* @param count 数量
	*/
	public void setCount(Integer count){
		this.count=count;
	}
}