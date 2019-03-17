package com.zq.vm.service;

import com.zq.vm.entity.CustomerNumbers;

import org.springframework.data.domain.Page;

/**
 * 描述: 余额信息业务接口
 * Time: 2019-02-24 18:46:04
 * @author: zou.qian
 * @version 1.0
 */
public interface CustomerNumbersService{

    /**
     * 保存
     * @param customerNumbers
     * @return
     */
	CustomerNumbers save(CustomerNumbers customerNumbers);

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
     * @param customerNumbers
     * @return
     */
    Page<CustomerNumbers> findPageByCriteria(int pageNumber, int pageSize, CustomerNumbers customerNumbers);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	CustomerNumbers findOne(String id);

}
