package com.zq.vm.entity.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.zq.vm.entity.CustomerSetMeal;

/**
 * 描述: 会员套餐关系表vo
 * Time: 2019-04-22 23:40:19
 * @author: zou.qian
 * @version 1.0
 */
public class CustomerSetMealVo{
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 
	 */
	private String customerId;
	/**
	 * 
	 */
	private String setMealId;
	/**
	 * 创建时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**
	 * 创建人id
	 */
	private String createUserId;

	/**
	 * 会员名称
	 */
	private String customerName;
	/**
	 * 套餐名称
	 */
	private String setMealName;
	/**
	 * 创建人名称
	 */
	private String createUserName;
	
	public static CustomerSetMealVo build(CustomerSetMeal customerSetMeal,String customerName,String setMealName,String createUserName){
		CustomerSetMealVo vo = new CustomerSetMealVo();
		BeanUtils.copyProperties(customerSetMeal, vo);
		vo.createTime = customerSetMeal.getCreateTime();
		vo.customerName = customerName;
		vo.setMealName = setMealName;
		vo.createUserName = createUserName;
		return vo;
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
	/**
	 * 获取会员名称
	 */
	public String getCustomerName(){
		return customerName;
	}
	/**
	* 设置会员名称
	* @param customerName 会员名称
	*/
	public void setCustomerName(String customerName){
		this.customerName=customerName;
	}
	/**
	 * 获取套餐名称
	 */
	public String getSetMealName(){
		return setMealName;
	}
	/**
	* 设置套餐名称
	* @param setMealName 套餐名称
	*/
	public void setSetMealName(String setMealName){
		this.setMealName=setMealName;
	}
	/**
	 * 获取创建人名称
	 */
	public String getCreateUserName(){
		return createUserName;
	}
	/**
	* 设置创建人名称
	* @param createUserName 创建人名称
	*/
	public void setCreateUserName(String createUserName){
		this.createUserName=createUserName;
	}
}