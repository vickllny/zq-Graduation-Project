package com.zq.vm.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 描述: 菜单实体类
 * Time: 2019-03-03 21:20:03
 * @author: zou.qian
 * @version 1.0
 */
@Entity
@Table(name="menu")
public class Menu{
	/**
	 * 
	 */
	@Id
	@GenericGenerator(name="idGenerator", strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	private String id;
	/**
	 * 
	 */
	@Column(name="NAME",length = 255, nullable = true)
	private String name;
	/**
	 * 
	 */
	@Column(name="PID",length = 36, nullable = true)
	private String pid;
	/**
	 * 
	 */
	@Column(name="URL",length = 255, nullable = true)
	private String url;
	
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
	 * 获取
	 */
	public String getName(){
		return name;
	}
	/**
	* 设置
	* @param name 
	*/
	public void setName(String name){
		this.name=name;
	}
	/**
	 * 获取
	 */
	public String getPid(){
		return pid;
	}
	/**
	* 设置
	* @param pid 
	*/
	public void setPid(String pid){
		this.pid=pid;
	}
	/**
	 * 获取
	 */
	public String getUrl(){
		return url;
	}
	/**
	* 设置
	* @param url 
	*/
	public void setUrl(String url){
		this.url=url;
	}
}