package com.zq.vm.service;

import com.zq.vm.entity.Balance;

import org.springframework.data.domain.Page;

/**
 * 描述: 余额信息业务接口
 * Time: 2019-02-24 18:26:07
 * @author: zou.qian
 * @version 1.0
 */
public interface BalanceService{

    /**
     * 保存
     * @param balance
     * @return
     */
	Balance save(Balance balance);

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
     * @param balance
     * @return
     */
    Page<Balance> findPageByCriteria(int pageNumber, int pageSize, Balance balance);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	Balance findOne(String id);

}
