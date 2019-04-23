package com.zq.vm.entity;

import javax.persistence.*;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述: 系统code实体类
 * Time: 2019-04-14 14:23:49
 * @author: zou.qian
 * @version 1.0
 */
@Entity
@Table(name="sys_code")
public class SysCode{
	/**
	 * 主键
	 */
	@Id
	@GenericGenerator(name="idGenerator", strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	private String id;
	/**
	 * 名称
	 */
	@Column(name="name",length = 255, nullable = false)
	private String name;
	/**
	 * 描述
	 */
	@Column(name="description",length = 255, nullable = true)
	private String description;
	/**
	 * code
	 */
	@Column(name="code",length = 255, nullable = false)
	private String code;
	/**
	 * 创建时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="create_time",length = 19, nullable = true)
	private Date createTime;
	
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
	 * 获取名称
	 */
	public String getName(){
		return name;
	}
	/**
	* 设置名称
	* @param name 名称
	*/
	public void setName(String name){
		this.name=name;
	}
	/**
	 * 获取描述
	 */
	public String getDescription(){
		return description;
	}
	/**
	* 设置描述
	* @param description 描述
	*/
	public void setDescription(String description){
		this.description=description;
	}
	/**
	 * 获取code
	 */
	public String getCode(){
		return code;
	}
	/**
	* 设置code
	* @param code code
	*/
	public void setCode(String code){
		this.code=code;
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
}