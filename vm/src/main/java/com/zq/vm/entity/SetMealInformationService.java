package com.zq.vm.entity;

import javax.persistence.*;

/**
 * 描述: 余额信息实体类
 * Time: 2019-02-24 19:09:31
 * @author: zou.qian
 * @version 1.0
 */
@Entity
@Table(name="set_meal_information_service")
public class SetMealInformationService{
	/**
	 * 主键
	 */
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private String id;
	/**
	 * 套餐id
	 */
	@Column(name="set_meal_information_id",length = 32, nullable = false)
	private String setMealInformationId;
	/**
	 * 服务id
	 */
	@Column(name="service_id",length = 32, nullable = false)
	private String serviceId;
	/**
	 * 服务次数
	 */
	@Column(name="count",length = 11, nullable = true)
	private Integer count;
	
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
	 * 获取服务id
	 */
	public String getServiceId(){
		return serviceId;
	}
	/**
	* 设置服务id
	* @param serviceId 服务id
	*/
	public void setServiceId(String serviceId){
		this.serviceId=serviceId;
	}
	/**
	 * 获取服务次数
	 */
	public Integer getCount(){
		return count;
	}
	/**
	* 设置服务次数
	* @param count 服务次数
	*/
	public void setCount(Integer count){
		this.count=count;
	}
}