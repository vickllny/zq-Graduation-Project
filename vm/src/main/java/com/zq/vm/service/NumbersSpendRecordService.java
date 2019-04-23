package com.zq.vm.service;

import com.zq.vm.entity.NumbersSpendRecord;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 描述: 服务次数消费记录表业务接口
 * Time: 2019-04-20 20:55:46
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

    /**
     * 查询所有
     * @return
     */
    List<NumbersSpendRecord> findAll();

    /**
     * 保存并扣除次数
     * @param numbersSpendRecord
     */
	void saveAndDeductionNumbers(NumbersSpendRecord numbersSpendRecord);
}
