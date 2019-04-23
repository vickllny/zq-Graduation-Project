package com.zq.vm.entity;

import javax.persistence.*;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述: 用户实体类
 * Time: 2019-03-17 18:55:24
 * @author: zou.qian
 * @version 1.0
 */
@Entity
@Table(name="user")
public class User{
	
	public static final String SUPER_USER_ID = "402816816a078232016a078f4f5c0021";
	/**
	 * 
	 */
	@Id
	@GenericGenerator(name="idGenerator", strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	private String id;
	/**
	 * 用户名
	 */
	@Column(name="user_name",length = 255, nullable = true)
	private String userName;
	/**
	 * 密码
	 */
	@Column(name="password",length = 255, nullable = true)
	private String password;
	/**
	 * 手机号码
	 */
	@Column(name="phone_number",length = 15, nullable = true)
	private String phoneNumber;
	/**
	 * 工号
	 */
	@Column(name="work_number",length = 255, nullable = true)
	private String workNumber;
	/**
	 * 角色id
	 */
	@Column(name="role_id",length = 36, nullable = true)
	private String roleId;
	/**
	 * 创建时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="create_time",length = 19, nullable = true)
	private Date createTime;
	/**
	 * 创建人id
	 */
	@Column(name="create_user_id",length = 255, nullable = true)
	private String createUserId;
	
	/**
	 * 获取
	 */
	public String getId(){
		return id;
	}
	/**
	* 设置
	* @param id 
	*/
	public void setId(String id){
		this.id=id;
	}
	/**
	 * 获取用户名
	 */
	public String getUserName(){
		return userName;
	}
	/**
	* 设置用户名
	* @param userName 用户名
	*/
	public void setUserName(String userName){
		this.userName=userName;
	}
	/**
	 * 获取密码
	 */
	public String getPassword(){
		return password;
	}
	/**
	* 设置密码
	* @param password 密码
	*/
	public void setPassword(String password){
		this.password=password;
	}
	/**
	 * 获取手机号码
	 */
	public String getPhoneNumber(){
		return phoneNumber;
	}
	/**
	* 设置手机号码
	* @param phoneNumber 手机号码
	*/
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber=phoneNumber;
	}
	/**
	 * 获取工号
	 */
	public String getWorkNumber(){
		return workNumber;
	}
	/**
	* 设置工号
	* @param workNumber 工号
	*/
	public void setWorkNumber(String workNumber){
		this.workNumber=workNumber;
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
	 * 获取创建人id
	 */
	public String getCreateUserId(){
		return createUserId;
	}
	/**
	* 设置创建人id
	* @param createUserId 创建人id
	*/
	public void setCreateUserId(String createUserId){
		this.createUserId=createUserId;
	}
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}