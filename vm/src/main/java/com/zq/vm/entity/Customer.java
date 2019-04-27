package com.zq.vm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述: 会员实体类
 * Time: 2019-03-25 14:23:23
 * @author: zou.qian
 * @version 1.0
 */
@Entity
@Table(name="customer")
public class Customer{
	/**
	 * 主键
	 */
	@Id
	@GenericGenerator(name="idGenerator", strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	private String id;
	/**
	 * 名字
	 */
	@Column(name="name",length = 32, nullable = false)
	private String name;
	/**
	 * 性别
	 */
	@Column(name="sex",length = 1, nullable = true)
	private Integer sex;
	/**
	 * 电话
	 */
	@Column(name="phone_number",length = 11, nullable = true)
	private String phoneNumber;
	/**
	 * 是否删除 1->删除 0->未删除
	 */
	@Column(name="del",length = 3, nullable = true)
	private Integer del;
	/**
	 * 创建时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "create_time")
	private Date createTime;
	/**
	 * birth
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "birth")
	private Date birth;
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
	 * 获取名字
	 */
	public String getName(){
		return name;
	}
	/**
	* 设置名字
	* @param name 名字
	*/
	public void setName(String name){
		this.name=name;
	}
	/**
	 * 获取性别
	 */
	public Integer getSex(){
		return sex;
	}
	/**
	* 设置性别
	* @param sex 性别
	*/
	public void setSex(Integer sex){
		this.sex=sex;
	}
	/**
	 * 获取电话
	 */
	public String getPhoneNumber(){
		return phoneNumber;
	}
	/**
	* 设置电话
	* @param phoneNumber 电话
	*/
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber=phoneNumber;
	}
	public Integer getDel() {
		return del;
	}
	public void setDel(Integer del) {
		this.del = del;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
}