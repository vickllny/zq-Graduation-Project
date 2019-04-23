package com.zq.vm.service;

import com.zq.vm.entity.RoleMenu;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 描述: 角色菜单业务接口
 * Time: 2019-04-10 20:54:16
 * @author: zou.qian
 * @version 1.0
 */
public interface RoleMenuService{

    /**
     * 保存
     * @param roleMenu
     * @return
     */
	RoleMenu save(RoleMenu roleMenu);

    /**
     * 删除
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param roleMenu
     * @return
     */
    Page<RoleMenu> findPageByCriteria(int pageNumber, int pageSize, RoleMenu roleMenu);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	RoleMenu findOne(String id);

    /**
     * 查询所有
     * @return
     */
    List<RoleMenu> findAll();

    /**
     * 保存角色id和菜单
     * @param roleId
     * @param menuIds
     */
	void save(String roleId, String[] menuIds);
	
	/**
	 * 根据角色id删除
	 * @param roleId
	 */
	void deleteByRoleId(String roleId);
}
