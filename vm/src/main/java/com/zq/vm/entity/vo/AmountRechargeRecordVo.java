package com.zq.vm.entity.vo;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zq.vm.entity.AmountRechargeRecord;

public class AmountRechargeRecordVo {
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 会员id
	 */
	private String customerId;
	/**
	 * 充值金额
	 */
	private BigDecimal rechargeAmount;
	/**
	 * 充值时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date rechargeTime;
	/**
	 * 会员名称
	 */
	private String customerName;
	
	
	public static AmountRechargeRecordVo build(AmountRechargeRecord amountRechargeRecord,String customerName) {
		AmountRechargeRecordVo vo = new AmountRechargeRecordVo();
		BeanUtils.copyProperties(amountRechargeRecord, vo);
		vo.setCustomerName(customerName);
		return vo;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public BigDecimal getRechargeAmount() {
		return rechargeAmount;
	}
	public void setRechargeAmount(BigDecimal rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}
	public Date getRechargeTime() {
		return rechargeTime;
	}
	public void setRechargeTime(Date rechargeTime) {
		this.rechargeTime = rechargeTime;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
