package com.zq.vm.service;

import com.zq.vm.entity.SysCode;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 描述: 系统code业务接口
 * Time: 2019-04-14 14:23:49
 * @author: zou.qian
 * @version 1.0
 */
public interface SysCodeService{

    /**
     * 保存
     * @param sysCode
     * @return
     */
	SysCode save(SysCode sysCode);

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
     * @param sysCode
     * @return
     */
    Page<SysCode> findPageByCriteria(int pageNumber, int pageSize, SysCode sysCode);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	SysCode findOne(String id);

    /**
     * 查询所有
     * @return
     */
    List<SysCode> findAll();

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
