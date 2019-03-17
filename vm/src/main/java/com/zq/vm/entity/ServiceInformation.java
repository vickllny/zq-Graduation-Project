package com.zq.vm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 描述: 余额信息实体类
 * Time: 2019-02-24 19:02:59
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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="create_time",length = 19, nullable = true)
	private Date createTime;
	/**
	 * 服务类别id
	 */
	@Column(name="service_class_id",length = 32, nullable = false)
	private String serviceClassId;
	
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
	 * 获取服务类别id
	 */
	public String getServiceClassId(){
		return serviceClassId;
	}
	/**
	* 设置服务类别id
	* @param serviceClassId 服务类别id
	*/
	public void setServiceClassId(String serviceClassId){
		this.serviceClassId=serviceClassId;
	}
}