package com.zq.vm.service;

import com.zq.vm.entity.NumbersRechargeRecord;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 描述: 服务次数充值记录表业务接口
 * Time: 2019-04-17 23:37:10
 * @author: zou.qian
 * @version 1.0
 */
public interface NumbersRechargeRecordService{

    /**
     * 保存
     * @param numbersRechargeRecord
     * @return
     */
	NumbersRechargeRecord save(NumbersRechargeRecord numbersRechargeRecord);

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
     * @param numbersRechargeRecord
     * @return
     */
    Page<NumbersRechargeRecord> findPageByCriteria(int pageNumber, int pageSize, NumbersRechargeRecord numbersRechargeRecord);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	NumbersRechargeRecord findOne(String id);

    /**
     * 查询所有
     * @return
     */
    List<NumbersRechargeRecord> findAll();

    /**
     * 保存充值记录并扣款
     * @param numbersRechargeRecord
     */
	void saveAndDeduction(NumbersRechargeRecord numbersRechargeRecord);
}
