package com.zq.vm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 描述: 余额信息实体类
 * Time: 2019-02-24 19:05:19
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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private String id;
	/**
	 * 套餐id
	 */
	@Column(name="name",length = 32, nullable = true)
	private String name;
	/**
	 * 套餐时限
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="meal_timelimit",length = 19, nullable = true)
	private Date mealTimelimit;
	/**
	 * 是否消费：1已消费，0未消费
	 */
	@Column(name="is_use",length = 1, nullable = true)
	private Integer isUse;
	
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
}