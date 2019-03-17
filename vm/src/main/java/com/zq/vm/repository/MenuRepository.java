package com.zq.vm.repository;

import com.zq.vm.entity.Menu;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

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

}
