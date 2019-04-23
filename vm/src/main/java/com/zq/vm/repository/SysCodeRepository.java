package com.zq.vm.repository;

import com.zq.vm.entity.SysCode;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 描述: 系统code业务数据访问类
 * Time: 2019-04-14 14:23:49
 * @author: zou.qian
 * @version 1.0
 */
public interface SysCodeRepository extends PagingAndSortingRepository<SysCode,String>, JpaSpecificationExecutor<SysCode> {

	/**
	 * 根据code查询系统编码
	 * @param code
	 * @return
	 */
	SysCode findByCode(String code);

	/**
	 * 根据名称和id查询
	 * @param name
	 * @param id 此处id是不等于 !=
	 * @return
	 */
	SysCode findByNameAndIdNot(String name, String id);

	/**
	 * 根据code和id查询
	 * @param name
	 * @param id 此处id是不等于 !=
	 * @return
	 */
	SysCode findByCodeAndIdNot(String code, String id);


}
