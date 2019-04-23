package com.zq.vm.entity;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 描述: 服务次数充值记录表实体类
 * Time: 2019-04-17 23:37:10
 * @author: zou.qian
 * @version 1.0
 */
@Entity
@Table(name="numbers_recharge_record")
public class NumbersRechargeRecord{
	/**
	 * 主键
	 */
	@Id
	@GenericGenerator(name="idGenerator", strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	private String id;
	/**
	 * 会员ID
	 */
	@Column(name="customer_id",length = 32, nullable = false)
	private String customerId;
	/**
	 * 充值次数
	 */
	@Column(name="recharge_numbers",length = 11, nullable = true)
	private Integer rechargeNumbers;
	/**
	 * 充值时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="recharge_time",length = 19, nullable = true)
	private Date rechargeTime;
	/**
	 * 服务id
	 */
	@Column(name="service_id",length = 32, nullable = false)
	private String serviceId;
	/**
	 * 消费金额
	 */
	@Column(name="spend_balance",length = 10, nullable = true)
	private BigDecimal spendBalance;
	/**
	 * 数量
	 */
	@Column(name="createUserId")
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
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
}