package com.zq.vm.service.impl;

import com.zq.vm.repository.NumbersRechargeRecordRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.NumbersRechargeRecord;
import com.zq.vm.service.NumbersRechargeRecordService;
import com.zq.vm.repository.specification.NumbersRechargeRecordSpecification;

/**
 * 描述:余额信息业务实现 
 * Time: 2019-02-24 18:48:13
 * @author: zou.qian
 * @version 1.0
 */
@Service
public class NumbersRechargeRecordServiceImpl extends BaseServiceImpl<NumbersRechargeRecord, String> implements NumbersRechargeRecordService{

	@Autowired
	private NumbersRechargeRecordRepository numbersRechargeRecordRepository;
	
    @Override
    public void delete(String id) {
        numbersRechargeRecordRepository.deleteById(id);
    }

    @Override
    public NumbersRechargeRecord findOne(String id) {
        return numbersRechargeRecordRepository.findById(id).orElse(new NumbersRechargeRecord());
    }

    @Override
    public NumbersRechargeRecord save(NumbersRechargeRecord numbersRechargeRecord) {
        return numbersRechargeRecordRepository.save(numbersRechargeRecord);
    }

    @Override
    public Page<NumbersRechargeRecord> findPageByCriteria(int pageNumber, int pageSize, final NumbersRechargeRecord numbersRechargeRecord) {
    	return numbersRechargeRecordRepository.findAll(NumbersRechargeRecordSpecification.specification(numbersRechargeRecord), buildPageRequest(pageNumber, pageSize));
    }
}
