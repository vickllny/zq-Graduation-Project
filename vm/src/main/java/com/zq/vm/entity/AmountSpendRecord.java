package com.zq.vm.entity;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 描述: 余额充值记录实体类
 * Time: 2019-03-23 13:44:04
 * @author: zou.qian
 * @version 1.0
 */
@Entity
@Table(name="amount_spend_record")
public class AmountSpendRecord{
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
	 * 商品id
	 */
	@Column(name="product_id",length = 32, nullable = false)
	private String productId;
	/**
	 * 花费金额
	 */
	@Column(name="amount_spend",length = 10, nullable = true)
	private BigDecimal amountSpend;
	/**
	 * 消费时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="spend_time",length = 19, nullable = true)
	private Date spendTime;
	/**
	 * 数量
	 */
	@Column(name="count")
	private Integer count;
	/**
	 * 创建人id
	 */
	@Column(name="createUserId")
	private String createUserId;
	/**
	 * 类别  1->普通商品消费  2->套餐商品消费
	 */
	@Column(name="type")
	private String type;
	
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
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}