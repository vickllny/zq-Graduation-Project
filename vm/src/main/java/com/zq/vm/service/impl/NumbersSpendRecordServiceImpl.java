package com.zq.vm.service.impl;

import com.zq.vm.repository.NumbersSpendRecordRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.NumbersSpendRecord;
import com.zq.vm.service.NumbersSpendRecordService;
import com.zq.vm.repository.specification.NumbersSpendRecordSpecification;

/**
 * 描述:余额信息业务实现 
 * Time: 2019-02-24 18:51:14
 * @author: zou.qian
 * @version 1.0
 */
@Service
public class NumbersSpendRecordServiceImpl extends BaseServiceImpl<NumbersSpendRecord, String> implements NumbersSpendRecordService{

	@Autowired
	private NumbersSpendRecordRepository numbersSpendRecordRepository;
	
    @Override
    public void delete(String id) {
        numbersSpendRecordRepository.deleteById(id);
    }

    @Override
    public NumbersSpendRecord findOne(String id) {
        return numbersSpendRecordRepository.findById(id).orElse(new NumbersSpendRecord());
    }

    @Override
    public NumbersSpendRecord save(NumbersSpendRecord numbersSpendRecord) {
        return numbersSpendRecordRepository.save(numbersSpendRecord);
    }

    @Override
    public Page<NumbersSpendRecord> findPageByCriteria(int pageNumber, int pageSize, final NumbersSpendRecord numbersSpendRecord) {
    	return numbersSpendRecordRepository.findAll(NumbersSpendRecordSpecification.specification(numbersSpendRecord), buildPageRequest(pageNumber, pageSize));
    }
}
