package com.zq.vm.entity;

import javax.persistence.*;

/**
 * 描述: 余额信息实体类
 * Time: 2019-02-24 18:46:04
 * @author: zou.qian
 * @version 1.0
 */
@Entity
@Table(name="customer_numbers")
public class CustomerNumbers{
	/**
	 * 主键
	 */
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private String id;
	/**
	 * 会员ID
	 */
	@Column(name="customer_id",length = 32, nullable = false)
	private String customerId;
	/**
	 * 次数
	 */
	@Column(name="numbers",length = 11, nullable = true)
	private Integer numbers;
	/**
	 * 服务id
	 */
	@Column(name="service_id",length = 32, nullable = false)
	private String serviceId;
	
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
	 * 获取会员ID
	 */
	public String getCustomerId(){
		return customerId;
	}
	/**
	* 设置会员ID
	* @param customerId 会员ID
	*/
	public void setCustomerId(String customerId){
		this.customerId=customerId;
	}
	/**
	 * 获取次数
	 */
	public Integer getNumbers(){
		return numbers;
	}
	/**
	* 设置次数
	* @param numbers 次数
	*/
	public void setNumbers(Integer numbers){
		this.numbers=numbers;
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
}