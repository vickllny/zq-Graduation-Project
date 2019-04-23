package com.zq.vm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 描述: 会员次数记录表实体类
 * Time: 2019-04-20 21:55:56
 * @author: zou.qian
 * @version 1.0
 */
@Entity
@Table(name="numbers")
public class Numbers{
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
	@Column(name="customer_id",length = 36, nullable = true)
	private String customerId;
	/**
	 * 服务id
	 */
	@Column(name="service_id",length = 36, nullable = true)
	private String serviceId;
	/**
	 * 次数
	 */
	@Column(name="numbers",length = 11, nullable = true)
	private Integer numbers;
	
	public Numbers() {}
	
	public Numbers(String customerId, String serviceId, Integer numbers) {
		super();
		this.customerId = customerId;
		this.serviceId = serviceId;
		this.numbers = numbers;
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
}