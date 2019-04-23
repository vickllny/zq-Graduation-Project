package com.zq.vm.service;

import com.zq.vm.entity.AmountSpendRecord;
import com.zq.vm.entity.vo.AmountSpendRecordVo;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 描述: 余额充值记录业务接口
 * Time: 2019-03-23 13:44:04
 * @author: zou.qian
 * @version 1.0
 */
public interface AmountSpendRecordService{

    /**
     * 保存
     * @param amountSpendRecord
     * @return
     */
	AmountSpendRecord save(AmountSpendRecord amountSpendRecord);

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
     * @param amountSpendRecord
     * @return
     */
    Page<AmountSpendRecord> findPageByCriteria(int pageNumber, int pageSize, AmountSpendRecord amountSpendRecord);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	AmountSpendRecord findOne(String id);

    /**
     * 查询所有
     * @return
     */
    List<AmountSpendRecord> findAll();

    /**
     * 搜索查询
     * @param pageNumber
     * @param pageSize
     * @param amountSpendRecord
     * @return
     */
	Page<AmountSpendRecord> findPageByCriteria(Integer pageNumber, Integer pageSize,
			AmountSpendRecordVo amountSpendRecord);
}
