package com.zq.vm.service.impl;

import com.zq.vm.repository.NumbersRechargeRecordRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.Balance;
import com.zq.vm.entity.Numbers;
import com.zq.vm.entity.NumbersRechargeRecord;
import com.zq.vm.service.BalanceService;
import com.zq.vm.service.NumbersRechargeRecordService;
import com.zq.vm.service.NumbersService;
import com.zq.vm.repository.specification.NumbersRechargeRecordSpecification;

/**
 * 描述:余额信息业务实现 
 * Time: 2019-02-24 18:48:13
 * @author: zou.qian
 * @version 1.0
 */
@Transactional
@Service
public class NumbersRechargeRecordServiceImpl extends BaseServiceImpl<NumbersRechargeRecord, String> implements NumbersRechargeRecordService{

	@Autowired
	private NumbersRechargeRecordRepository numbersRechargeRecordRepository;
	@Autowired
	private BalanceService balanceService;
	@Autowired
	private NumbersService numbersService;
	
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

	@Override
	public List<NumbersRechargeRecord> findAll() {
		return findList(numbersRechargeRecordRepository.findAll());
	}

	@Override
	public void saveAndDeduction(NumbersRechargeRecord numbersRechargeRecord) {
		numbersRechargeRecordRepository.save(numbersRechargeRecord);
		Balance balance = balanceService.findByCustomerId(numbersRechargeRecord.getCustomerId());
		if(balance == null) {
			throw new RuntimeException("会员相关信息不存在，请重试");
		}
		if(balance.getBalance().compareTo(numbersRechargeRecord.getSpendBalance()) == -1) {
			throw new RuntimeException("会员余额不足，请充值余额");
		}
		balance.setBalance(balance.getBalance().subtract(numbersRechargeRecord.getSpendBalance()));
		balanceService.save(balance);
		//同步次数信息
		numbersService.save(new Numbers(numbersRechargeRecord.getCustomerId(), numbersRechargeRecord.getServiceId(), numbersRechargeRecord.getRechargeNumbers()));
	}
}
