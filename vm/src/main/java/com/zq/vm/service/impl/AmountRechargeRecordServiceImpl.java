package com.zq.vm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zq.vm.entity.AmountRechargeRecord;
import com.zq.vm.entity.Balance;
import com.zq.vm.repository.AmountRechargeRecordRepository;
import com.zq.vm.repository.specification.AmountRechargeRecordSpecification;
import com.zq.vm.service.AmountRechargeRecordService;
import com.zq.vm.service.BalanceService;
import com.zq.vm.service.CustomerSetMealService;
import com.zq.vm.utils.SpringContextUtil;

/**
 * 描述:余额充值记录业务实现 
 * Time: 2019-03-23 12:49:34
 * @author: zou.qian
 * @version 1.0
 */
@Transactional
@Service
public class AmountRechargeRecordServiceImpl extends BaseServiceImpl<AmountRechargeRecord, String> implements AmountRechargeRecordService{

	@Autowired
	private AmountRechargeRecordRepository amountRechargeRecordRepository;
	@Autowired
	private BalanceService balanceService;
	
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
    	AmountRechargeRecord save = amountRechargeRecordRepository.save(amountRechargeRecord);
    	Balance balance = balanceService.findByCustomerId(save.getCustomerId());
    	if(balance == null) {
    		balance = new Balance();
    		balance.setBalance(save.getRechargeAmount());
    		balance.setCustomerId(save.getCustomerId());
    	}else {
    		balance.setBalance(balance.getBalance().add(save.getRechargeAmount()));
    	}
    	balanceService.save(balance);
        return save;
    }

    @Override
    public Page<AmountRechargeRecord> findPageByCriteria(int pageNumber, int pageSize, final AmountRechargeRecord amountRechargeRecord) {
    	return amountRechargeRecordRepository.findAll(AmountRechargeRecordSpecification.specification(amountRechargeRecord), buildPageRequest(pageNumber, pageSize));
    }

    @Override
    public List<AmountRechargeRecord> findAll() {
        return super.findList(amountRechargeRecordRepository.findAll());
    }
}
