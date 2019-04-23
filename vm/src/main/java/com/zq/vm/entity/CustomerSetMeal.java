package com.zq.vm.entity;

import javax.persistence.*;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 描述: 会员套餐关系表实体类
 * Time: 2019-04-22 23:40:19
 * @author: zou.qian
 * @version 1.0
 */
@Entity
@Table(name="customer_set_meal")
public class CustomerSetMeal{
	/**
	 * 主键
	 */
	@Id
	@GenericGenerator(name="idGenerator", strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	private String id;
	/**
	 * 
	 */
	@Column(name="customer_id",length = 36, nullable = false)
	private String customerId;
	/**
	 * 
	 */
	@Column(name="set_meal_id",length = 36, nullable = false)
	private String setMealId;
	/**
	 * 创建时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="create_time",length = 19, nullable = true)
	private Date createTime;
	/**
	 * 创建人id
	 */
	@Column(name="create_user_id",length = 36, nullable = false)
	private String createUserId;
	
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
	 * 获取
	 */
	public String getCustomerId(){
		return customerId;
	}
	/**
	* 设置
	* @param customerId 
	*/
	public void setCustomerId(String customerId){
		this.customerId=customerId;
	}
	/**
	 * 获取
	 */
	public String getSetMealId(){
		return setMealId;
	}
	/**
	* 设置
	* @param setMealId 
	*/
	public void setSetMealId(String setMealId){
		this.setMealId=setMealId;
	}
	/**
	 * 获取创建时间
	 */
	public Date getCreateTime(){
		return createTime;
	}
	/**
	* 设置创建时间
	* @param createTime 创建时间
	*/
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	/**
	 * 获取创建人id
	 */
	public String getCreateUserId(){
		return createUserId;
	}
	/**
	* 设置创建人id
	* @param createUserId 创建人id
	*/
	public void setCreateUserId(String createUserId){
		this.createUserId=createUserId;
	}
}