package com.zq.vm.entity;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 描述: 套餐管理实体类
 * Time: 2019-03-25 22:25:50
 * @author: zou.qian
 * @version 1.0
 */
@Entity
@Table(name="set_meal_information")
public class SetMealInformation{
	/**
	 * 主键
	 */
	@Id
	@GenericGenerator(name="idGenerator", strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	private String id;
	/**
	 * 套餐id
	 */
	@Column(name="name",length = 32, nullable = true)
	private String name;
	/**
	 * 套餐时限
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="meal_timelimit",length = 19, nullable = true)
	private Date mealTimelimit;
	/**
	 * 是否启用：1是，0否
	 */
	@Column(name="is_use",length = 1, nullable = true)
	private Integer isUse;
	/**
	 * 单价
	 */
	@Column(name="price",length = 10,precision=3, nullable = true)
	private BigDecimal price;
	
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
	 * 获取套餐id
	 */
	public String getName(){
		return name;
	}
	/**
	* 设置套餐id
	* @param name 套餐id
	*/
	public void setName(String name){
		this.name=name;
	}
	/**
	 * 获取套餐时限
	 */
	public Date getMealTimelimit(){
		return mealTimelimit;
	}
	/**
	* 设置套餐时限
	* @param mealTimelimit 套餐时限
	*/
	public void setMealTimelimit(Date mealTimelimit){
		this.mealTimelimit=mealTimelimit;
	}
	/**
	 * 获取是否消费：1已消费，0未消费
	 */
	public Integer getIsUse(){
		return isUse;
	}
	/**
	* 设置是否消费：1已消费，0未消费
	* @param isUse 是否消费：1已消费，0未消费
	*/
	public void setIsUse(Integer isUse){
		this.isUse=isUse;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}