package com.zq.vm.repository;

import com.zq.vm.entity.RoleMenu;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 描述: 角色菜单业务数据访问类
 * Time: 2019-04-10 20:54:16
 * @author: zou.qian
 * @version 1.0
 */
public interface RoleMenuRepository extends PagingAndSortingRepository<RoleMenu,String>, JpaSpecificationExecutor<RoleMenu> {

	void deleteByRoleId(String roleId);

}
