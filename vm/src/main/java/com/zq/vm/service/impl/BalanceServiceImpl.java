package com.zq.vm.service.impl;

import com.zq.vm.repository.BalanceRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.Balance;
import com.zq.vm.service.BalanceService;
import com.zq.vm.repository.specification.BalanceSpecification;

import java.util.List;

/**
 * 描述:余额业务实现 
 * Time: 2019-03-25 13:45:13
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

    @Override
    public List<Balance> findAll() {
        return super.findList(balanceRepository.findAll());
    }

	@Override
	public Balance findByCustomerId(String customerId) {
		return balanceRepository.findByCustomerId(customerId);
	}

	@Override
	public Page<Balance> findPageByCriteria(Integer pageNumber, Integer pageSize, String customerName) {
		//处理customerName为null的时候
		customerName = StringUtils.isBlank(customerName)?"":customerName;
		return balanceRepository.findPage("%"+customerName+"%", buildPageRequest(pageNumber, pageSize));
	}
}
