package com.zq.vm.service;

import com.zq.vm.entity.Role;
import com.zq.vm.entity.ZTree;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 描述: 角色业务接口
 * Time: 2019-03-22 22:05:20
 * @author: zou.qian
 * @version 1.0
 */
public interface RoleService{

    /**
     * 保存
     * @param role
     * @return
     */
	Role save(Role role);

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
     * @param role
     * @return
     */
    Page<Role> findPageByCriteria(int pageNumber, int pageSize, Role role);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	Role findOne(String id);

    /**
     * 查询所有
     * @return
     */
    List<Role> findAll();

    /**
     * 根据角色id查询关联的菜单树
     * @param roleId
     * @return
     */
	List<ZTree> permission(String roleId);
}
