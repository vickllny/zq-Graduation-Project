package com.zq.vm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 描述: 余额信息实体类
 * Time: 2019-02-24 18:51:14
 * @author: zou.qian
 * @version 1.0
 */
@Entity
@Table(name="numbers_spend_record")
public class NumbersSpendRecord{
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
	 * 消费次数
	 */
	@Column(name="spend_numbers",length = 11, nullable = true)
	private Integer spendNumbers;
	/**
	 * 消费时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="spend_time",length = 19, nullable = true)
	private Date spendTime;
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
	 * 获取消费次数
	 */
	public Integer getSpendNumbers(){
		return spendNumbers;
	}
	/**
	* 设置消费次数
	* @param spendNumbers 消费次数
	*/
	public void setSpendNumbers(Integer spendNumbers){
		this.spendNumbers=spendNumbers;
	}
	/**
	 * 获取消费时间
	 */
	public Date getSpendTime(){
		return spendTime;
	}
	/**
	* 设置消费时间
	* @param spendTime 消费时间
	*/
	public void setSpendTime(Date spendTime){
		this.spendTime=spendTime;
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