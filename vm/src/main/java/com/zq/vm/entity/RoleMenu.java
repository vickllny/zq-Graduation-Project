package com.zq.vm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 描述: 角色菜单实体类
 * Time: 2019-04-10 20:54:16
 * @author: zou.qian
 * @version 1.0
 */
@Entity
@Table(name="role_menu")
public class RoleMenu{
	/**
	 * 主键
	 */
	@Id
	@GenericGenerator(name="idGenerator", strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	private String id;
	/**
	 * 角色id
	 */
	@Column(name="role_id",length = 36, nullable = false)
	private String roleId;
	/**
	 * 菜单id
	 */
	@Column(name="menu_id",length = 36, nullable = false)
	private String menuId;
	
	public RoleMenu() {}
	
	public RoleMenu(String roleId, String menuId) {
		this.roleId = roleId;
		this.menuId = menuId;
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
	 * 获取角色id
	 */
	public String getRoleId(){
		return roleId;
	}
	/**
	* 设置角色id
	* @param roleId 角色id
	*/
	public void setRoleId(String roleId){
		this.roleId=roleId;
	}
	/**
	 * 获取菜单id
	 */
	public String getMenuId(){
		return menuId;
	}
	/**
	* 设置菜单id
	* @param menuId 菜单id
	*/
	public void setMenuId(String menuId){
		this.menuId=menuId;
	}
}