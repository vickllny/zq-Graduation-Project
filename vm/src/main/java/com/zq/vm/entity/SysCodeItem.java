package com.zq.vm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 描述: 系统编码值实体类
 * Time: 2019-04-14 16:00:27
 * @author: zou.qian
 * @version 1.0
 */
@Entity
@Table(name="sys_code_item")
public class SysCodeItem{
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
	 * code
	 */
	@Column(name="code",length = 255, nullable = false)
	private String code;
	/**
	 * 排序
	 */
	@Column(name="sort",length = 11, nullable = true)
	private Integer sort;
	/**
	 * code_id
	 */
	@Column(name="sys_code_id",length = 36, nullable = false)
	private String sysCodeId;
	
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
	 * 获取排序
	 */
	public Integer getSort(){
		return sort;
	}
	/**
	* 设置排序
	* @param sort 排序
	*/
	public void setSort(Integer sort){
		this.sort=sort;
	}
	/**
	 * 获取code_id
	 */
	public String getSysCodeId(){
		return sysCodeId;
	}
	/**
	* 设置code_id
	* @param sysCodeId code_id
	*/
	public void setSysCodeId(String sysCodeId){
		this.sysCodeId=sysCodeId;
	}
}