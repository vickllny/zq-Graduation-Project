package com.zq.vm.entity;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 描述: 余额充值记录实体类
 * Time: 2019-03-23 12:49:34
 * @author: zou.qian
 * @version 1.0
 */
@Entity
@Table(name="amount_recharge_record")
public class AmountRechargeRecord{
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
	@Column(name="customer_id",length = 32, nullable = false)
	private String customerId;
	/**
	 * 充值金额
	 */
	@Column(name="recharge_amount",length = 32,precision=3,nullable = true)
	private BigDecimal rechargeAmount;
	/**
	 * 充值时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="recharge_time",length = 19, nullable = true)
	private Date rechargeTime;
	
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
	 * 获取充值金额
	 */
	public BigDecimal getRechargeAmount(){
		return rechargeAmount;
	}
	/**
	* 设置充值金额
	* @param rechargeAmount 充值金额
	*/
	public void setRechargeAmount(BigDecimal rechargeAmount){
		this.rechargeAmount=rechargeAmount;
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
}