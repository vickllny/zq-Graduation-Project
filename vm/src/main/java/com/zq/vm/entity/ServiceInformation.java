package com.zq.vm.entity;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述: 服务信息表(商品)实体类
 * Time: 2019-04-16 23:18:35
 * @author: zou.qian
 * @version 1.0
 */
@Entity
@Table(name="service_information")
public class ServiceInformation{
	/**
	 * 主键
	 */
	@Id
	@GenericGenerator(name="idGenerator", strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	private String id;
	/**
	 * 服务名称
	 */
	@Column(name="name",length = 128, nullable = true)
	private String name;
	/**
	 * 服务描述
	 */
	@Column(name="description",length = 255, nullable = true)
	private String description;
	/**
	 * 创建时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="create_time",length = 19, nullable = true)
	private Date createTime;
	/**
	 * 服务类别
	 */
	@Column(name="type",length = 32, nullable = false)
	private String type;
	/**
	 * 单价
	 */
	@Column(name="unit_price",length = 10,precision=3, nullable = true)
	private BigDecimal unitPrice;
	
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
	 * 获取服务名称
	 */
	public String getName(){
		return name;
	}
	/**
	* 设置服务名称
	* @param name 服务名称
	*/
	public void setName(String name){
		this.name=name;
	}
	/**
	 * 获取服务描述
	 */
	public String getDescription(){
		return description;
	}
	/**
	* 设置服务描述
	* @param description 服务描述
	*/
	public void setDescription(String description){
		this.description=description;
	}
	/**
	 * 获取创建时间
	 */
	public Date getCreateTime(){
		return createTime;
	}
	/**
	* 设置创建时间
	* @param createTime 创建时间
	*/
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	/**
	 * 获取服务类别
	 */
	public String getType(){
		return type;
	}
	/**
	* 设置服务类别
	* @param type 服务类别
	*/
	public void setType(String type){
		this.type=type;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
}