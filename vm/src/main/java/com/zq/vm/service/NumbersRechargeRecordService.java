package com.zq.vm.service;

import com.zq.vm.entity.NumbersRechargeRecord;

import org.springframework.data.domain.Page;

/**
 * 描述: 余额信息业务接口
 * Time: 2019-02-24 18:48:13
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

}
