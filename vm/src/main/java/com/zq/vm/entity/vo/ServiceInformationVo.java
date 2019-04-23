package com.zq.vm.entity.vo;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zq.vm.entity.ServiceInformation;

/**
 * 描述: 服务信息表(商品)实体类
 * Time: 2019-04-16 23:18:35
 * @author: zou.qian
 * @version 1.0
 */
public class ServiceInformationVo{
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 服务名称
	 */
	private String name;
	/**
	 * 服务描述
	 */
	private String description;
	/**
	 * 创建时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**
	 * 服务类别
	 */
	private String type;
	/**
	 * 类别名称
	 */
	private String typeName;
	
	public static ServiceInformationVo build(ServiceInformation serviceInformation,String typeName) {
		ServiceInformationVo vo = new ServiceInformationVo();
		BeanUtils.copyProperties(serviceInformation, vo);
		vo.typeName = typeName;
		return vo;
	}
	
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
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}