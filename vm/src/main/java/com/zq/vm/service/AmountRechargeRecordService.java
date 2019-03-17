package com.zq.vm.service;

import com.zq.vm.entity.AmountRechargeRecord;

import org.springframework.data.domain.Page;

/**
 * 描述: 余额信息业务接口
 * Time: 2019-02-24 18:31:50
 * @author: zou.qian
 * @version 1.0
 */
public interface AmountRechargeRecordService{

    /**
     * 保存
     * @param amountRechargeRecord
     * @return
     */
	AmountRechargeRecord save(AmountRechargeRecord amountRechargeRecord);

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
     * @param amountRechargeRecord
     * @return
     */
    Page<AmountRechargeRecord> findPageByCriteria(int pageNumber, int pageSize, AmountRechargeRecord amountRechargeRecord);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	AmountRechargeRecord findOne(String id);

}
