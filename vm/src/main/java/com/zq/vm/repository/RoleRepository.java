package com.zq.vm.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.zq.vm.entity.Role;

/**
 * 描述: 角色业务数据访问类
 * Time: 2019-03-22 22:05:20
 * @author: zou.qian
 * @version 1.0
 */
public interface RoleRepository extends PagingAndSortingRepository<Role,String>, JpaSpecificationExecutor<Role> {

	@Query(nativeQuery = true, value = "select m.*,case when r.id is not null then 1 else 0 END as FLAG from menu m LEFT JOIN role_menu rm on rm.menu_id = m.id LEFT JOIN role r on r.id = rm.role_id and r.id = :roleId where 1=1 ")
	List<Map<String, Object>> permission(@Param("roleId")String roleId);


}
