package com.zq.vm.entity;


import javax.persistence.*;



/**
 * 描述: 会员信息实体类
 * Time: 2019-02-24 14:58:24
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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
}