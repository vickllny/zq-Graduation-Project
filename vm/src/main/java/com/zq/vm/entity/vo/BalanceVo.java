package com.zq.vm.entity.vo;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;

import com.zq.vm.entity.Balance;

/**
 * 描述: 余额实体类
 * Time: 2019-03-25 13:45:13
 * @author: zou.qian
 * @version 1.0
 */
public class BalanceVo{
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 会员ID
	 */
	private String customerId;
	/**
	 * 余额
	 */
	private BigDecimal balance;
	/**
	 * 会员名称
	 */
	private String customerName;
	/**
	 * 单价
	 */
	private BigDecimal unitPrice;
	
	public static BalanceVo build(Balance balance,String customerName) {
		BalanceVo vo = new BalanceVo();
		BeanUtils.copyProperties(balance, vo);
		vo.customerName = customerName;
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
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
}