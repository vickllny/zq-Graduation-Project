package com.zq.vm.service;

import com.zq.vm.entity.Balance;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 描述: 余额业务接口
 * Time: 2019-03-25 13:45:13
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

    /**
     * 查询所有
     * @return
     */
    List<Balance> findAll();

    /**
     * 根据customerId查询
     * @param customerId
     * @return
     */
	Balance findByCustomerId(String customerId);

	/**
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @param customerName
	 * @return
	 */
	Page<Balance> findPageByCriteria(Integer pageNumber, Integer pageSize, String customerName);
}
