package com.zq.vm.service.impl;

import com.zq.vm.repository.AmountRechargeRecordRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.AmountRechargeRecord;
import com.zq.vm.service.AmountRechargeRecordService;
import com.zq.vm.repository.specification.AmountRechargeRecordSpecification;

/**
 * 描述:余额信息业务实现 
 * Time: 2019-02-24 18:31:50
 * @author: zou.qian
 * @version 1.0
 */
@Service
public class AmountRechargeRecordServiceImpl extends BaseServiceImpl<AmountRechargeRecord, String> implements AmountRechargeRecordService{

	@Autowired
	private AmountRechargeRecordRepository amountRechargeRecordRepository;
	
    @Override
    public void delete(String id) {
        amountRechargeRecordRepository.deleteById(id);
    }

    @Override
    public AmountRechargeRecord findOne(String id) {
        return amountRechargeRecordRepository.findById(id).orElse(new AmountRechargeRecord());
    }

    @Override
    public AmountRechargeRecord save(AmountRechargeRecord amountRechargeRecord) {
        return amountRechargeRecordRepository.save(amountRechargeRecord);
    }

    @Override
    public Page<AmountRechargeRecord> findPageByCriteria(int pageNumber, int pageSize, final AmountRechargeRecord amountRechargeRecord) {
    	return amountRechargeRecordRepository.findAll(AmountRechargeRecordSpecification.specification(amountRechargeRecord), buildPageRequest(pageNumber, pageSize));
    }
}
