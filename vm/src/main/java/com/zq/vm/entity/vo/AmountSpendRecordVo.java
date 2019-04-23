package com.zq.vm.entity.vo;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zq.vm.entity.AmountSpendRecord;

/**
 * 描述: 余额充值记录实体类
 * Time: 2019-03-23 13:44:04
 * @author: zou.qian
 * @version 1.0
 */
public class AmountSpendRecordVo{
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 会员id
	 */
	private String customerId;
	/**
	 * 商品id
	 */
	private String productId;
	/**
	 * 花费金额
	 */
	private BigDecimal amountSpend;
	/**
	 * 消费时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date spendTime;
	/**
	 * 数量
	 */
	private Integer count;
	/**
	 * 会员名
	 */
	private String customerName;
	/**
	 * 商品名称
	 */
	private String productName;
	/**
	 * 创建人名称
	 */
	private String createUserName;
	
	public static AmountSpendRecordVo build(AmountSpendRecord amountSpendRecord,String customerName,String productName,String createUserName) {
		AmountSpendRecordVo vo = new AmountSpendRecordVo();
		BeanUtils.copyProperties(amountSpendRecord, vo);
		vo.customerName = customerName;
		vo.productName = productName;
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
	 * 获取商品id
	 */
	public String getProductId(){
		return productId;
	}
	/**
	* 设置商品id
	* @param productId 商品id
	*/
	public void setProductId(String productId){
		this.productId=productId;
	}
	/**
	 * 获取花费金额
	 */
	public BigDecimal getAmountSpend(){
		return amountSpend;
	}
	/**
	* 设置花费金额
	* @param amountSpend 花费金额
	*/
	public void setAmountSpend(BigDecimal amountSpend){
		this.amountSpend=amountSpend;
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
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
}