package com.zq.vm.entity;

import javax.persistence.*;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 描述: 角色实体类
 * Time: 2019-03-22 22:05:20
 * @author: zou.qian
 * @version 1.0
 */
@Entity
@Table(name="role")
public class Role{
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
	 * 状态，0->禁用，1->启用
	 */
	@Column(name="status",length = 1, nullable = false)
	private Integer status;
	/**
	 * 创建时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="create_time",length = 19, nullable = true)
	private Date createTime;
	/**
	 * 角色编码
	 */
	@Column(name="role_code",length = 64, nullable = false)
	private String roleCode;
	
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
	 * 获取状态，0->禁用，1->启用
	 */
	public Integer getStatus(){
		return status;
	}
	/**
	* 设置状态，0->禁用，1->启用
	* @param status 状态，0->禁用，1->启用
	*/
	public void setStatus(Integer status){
		this.status=status;
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
	 * 获取角色编码
	 */
	public String getRoleCode(){
		return roleCode;
	}
	/**
	* 设置角色编码
	* @param roleCode 角色编码
	*/
	public void setRoleCode(String roleCode){
		this.roleCode=roleCode;
	}
}