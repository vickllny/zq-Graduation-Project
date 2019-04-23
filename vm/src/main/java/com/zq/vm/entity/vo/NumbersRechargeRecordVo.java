package com.zq.vm.entity.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zq.vm.entity.NumbersRechargeRecord;

import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 描述: 服务次数充值记录表vo
 * Time: 2019-04-17 23:37:10
 * @author: zou.qian
 * @version 1.0
 */
public class NumbersRechargeRecordVo{
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 会员ID
	 */
	private String customerId;
	/**
	 * 充值次数
	 */
	private Integer rechargeNumbers;
	/**
	 * 充值时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date rechargeTime;
	/**
	 * 服务id
	 */
	private String serviceId;
	/**
	 * 消费金额
	 */
	private BigDecimal spendBalance;

	/**
	 * 会员名称
	 */
	private String customerName;
	/**
	 * 服务名称
	 */
	private String serviceName;
	/**
	 * 创建人名称
	 */
	private String createUserName;
	
	public static NumbersRechargeRecordVo build(NumbersRechargeRecord numbersRechargeRecord,String customerName,String serviceName,String createUserName){
		NumbersRechargeRecordVo vo = new NumbersRechargeRecordVo();
		BeanUtils.copyProperties(numbersRechargeRecord, vo);
		vo.customerName = customerName;
		vo.serviceName = serviceName;
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
	 * 获取充值次数
	 */
	public Integer getRechargeNumbers(){
		return rechargeNumbers;
	}
	/**
	* 设置充值次数
	* @param rechargeNumbers 充值次数
	*/
	public void setRechargeNumbers(Integer rechargeNumbers){
		this.rechargeNumbers=rechargeNumbers;
	}
	/**
	 * 获取充值时间
	 */
	public Date getRechargeTime(){
		return rechargeTime;
	}
	/**
	* 设置充值时间
	* @param rechargeTime 充值时间
	*/
	public void setRechargeTime(Date rechargeTime){
		this.rechargeTime=rechargeTime;
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
	 * 获取消费金额
	 */
	public BigDecimal getSpendBalance(){
		return spendBalance;
	}
	/**
	* 设置消费金额
	* @param spendBalance 消费金额
	*/
	public void setSpendBalance(BigDecimal spendBalance){
		this.spendBalance=spendBalance;
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

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
}