package com.zq.vm.service.impl;

import com.zq.vm.repository.BalanceRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.Balance;
import com.zq.vm.service.BalanceService;
import com.zq.vm.repository.specification.BalanceSpecification;

/**
 * 描述:余额信息业务实现 
 * Time: 2019-02-24 18:26:07
 * @author: zou.qian
 * @version 1.0
 */
@Service
public class BalanceServiceImpl extends BaseServiceImpl<Balance, String> implements BalanceService{

	@Autowired
	private BalanceRepository balanceRepository;
	
    @Override
    public void delete(String id) {
        balanceRepository.deleteById(id);
    }

    @Override
    public Balance findOne(String id) {
        return balanceRepository.findById(id).orElse(new Balance());
    }

    @Override
    public Balance save(Balance balance) {
        return balanceRepository.save(balance);
    }

    @Override
    public Page<Balance> findPageByCriteria(int pageNumber, int pageSize, final Balance balance) {
    	return balanceRepository.findAll(BalanceSpecification.specification(balance), buildPageRequest(pageNumber, pageSize));
    }
}
