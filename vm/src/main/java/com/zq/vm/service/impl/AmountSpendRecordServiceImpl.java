package com.zq.vm.service.impl;

import com.zq.vm.repository.AmountSpendRecordRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.AmountSpendRecord;
import com.zq.vm.service.AmountSpendRecordService;
import com.zq.vm.repository.specification.AmountSpendRecordSpecification;

/**
 * 描述:余额信息业务实现 
 * Time: 2019-02-24 18:39:13
 * @author: zou.qian
 * @version 1.0
 */
@Service
public class AmountSpendRecordServiceImpl extends BaseServiceImpl<AmountSpendRecord, String> implements AmountSpendRecordService{

	@Autowired
	private AmountSpendRecordRepository amountSpendRecordRepository;
	
    @Override
    public void delete(String id) {
        amountSpendRecordRepository.deleteById(id);
    }

    @Override
    public AmountSpendRecord findOne(String id) {
        return amountSpendRecordRepository.findById(id).orElse(new AmountSpendRecord());
    }

    @Override
    public AmountSpendRecord save(AmountSpendRecord amountSpendRecord) {
        return amountSpendRecordRepository.save(amountSpendRecord);
    }

    @Override
    public Page<AmountSpendRecord> findPageByCriteria(int pageNumber, int pageSize, final AmountSpendRecord amountSpendRecord) {
    	return amountSpendRecordRepository.findAll(AmountSpendRecordSpecification.specification(amountSpendRecord), buildPageRequest(pageNumber, pageSize));
    }
}
