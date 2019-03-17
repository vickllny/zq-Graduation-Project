package com.zq.vm.service;

import com.zq.vm.entity.NumbersSpendRecord;

import org.springframework.data.domain.Page;

/**
 * 描述: 余额信息业务接口
 * Time: 2019-02-24 18:51:14
 * @author: zou.qian
 * @version 1.0
 */
public interface NumbersSpendRecordService{

    /**
     * 保存
     * @param numbersSpendRecord
     * @return
     */
	NumbersSpendRecord save(NumbersSpendRecord numbersSpendRecord);

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
     * @param numbersSpendRecord
     * @return
     */
    Page<NumbersSpendRecord> findPageByCriteria(int pageNumber, int pageSize, NumbersSpendRecord numbersSpendRecord);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	NumbersSpendRecord findOne(String id);

}
