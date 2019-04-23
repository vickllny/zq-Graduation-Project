package com.zq.vm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

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
	 * 年龄
	 */
	@Column(name="age",length = 3, nullable = true)
	private Integer age;
	/**
	 * 是否删除 1->删除 0->未删除
	 */
	@Column(name="del",length = 3, nullable = true)
	private Integer del;
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
	/**
	 * 获取年龄
	 */
	public Integer getAge(){
		return age;
	}
	/**
	* 设置年龄
	* @param age 年龄
	*/
	public void setAge(Integer age){
		this.age=age;
	}
	public Integer getDel() {
		return del;
	}
	public void setDel(Integer del) {
		this.del = del;
	}
}