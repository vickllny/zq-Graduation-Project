package com.zq.vm.repository;

import com.zq.vm.entity.Menu;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * 描述: 菜单业务数据访问类
 * Time: 2019-03-03 21:20:03
 * @author: zou.qian
 * @version 1.0
 */
public interface MenuRepository extends PagingAndSortingRepository<Menu,String>, JpaSpecificationExecutor<Menu> {

	/**
	 * 根据pid查询
	 * @param id
	 * @return
	 */
	List<Menu> findByPid(String id);

	/**
	 * 根据userId查询菜单
	 * @param userId
	 * @return
	 */
	@Query(nativeQuery = true, value = "select m.* from menu m inner join role_menu rm on rm.menu_id = m.id inner JOIN user u on u.role_id = rm.role_id where 1=1 and u.id = :userId")
	List<Menu> findMenuByUserId(@Param(value = "userId")String userId);

}
