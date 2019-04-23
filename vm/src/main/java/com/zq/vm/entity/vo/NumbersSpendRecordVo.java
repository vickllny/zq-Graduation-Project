package com.zq.vm.entity.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.zq.vm.entity.NumbersSpendRecord;

/**
 * 描述: 服务次数消费记录表vo
 * Time: 2019-04-20 20:55:46
 * @author: zou.qian
 * @version 1.0
 */
public class NumbersSpendRecordVo{
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 会员ID
	 */
	private String customerId;
	/**
	 * 消费次数
	 */
	private Integer spendNumbers;
	/**
	 * 消费时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date spendTime;
	/**
	 * 服务id
	 */
	private String serviceId;

	/**
	 * 会员名称
	 */
	private String customerName;
	/**
	 * 服务名称
	 */
	private String serviceName;
	
	public static NumbersSpendRecordVo build(NumbersSpendRecord numbersSpendRecord,String customerName,String serviceName){
		NumbersSpendRecordVo vo = new NumbersSpendRecordVo();
		BeanUtils.copyProperties(numbersSpendRecord, vo);
		vo.customerName = customerName;
		vo.serviceName = serviceName;
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
	 * 获取服务名称
	 */
	public String getServiceName(){
		return serviceName;
	}
	/**
	* 设置服务名称
	* @param serviceName 服务名称
	*/
	public void setServiceName(String serviceName){
		this.serviceName=serviceName;
	}
}