package com.zq.vm.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 描述: 余额实体类
 * Time: 2019-03-25 13:45:13
 * @author: zou.qian
 * @version 1.0
 */
@Entity
@Table(name="balance")
public class Balance{
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
	 * 余额
	 */
	@Column(name="balance",length = 10,precision=3, nullable = true)
	private BigDecimal balance;

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
	 * 获取余额
	 */
	public BigDecimal getBalance(){
		return balance;
	}
	/**
	 * 设置余额
	 * @param balance 余额
	 */
	public void setBalance(BigDecimal balance){
		this.balance=balance;
	}
}