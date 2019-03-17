package com.zq.vm.service.impl;

import com.zq.vm.repository.CustomerNumbersRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.CustomerNumbers;
import com.zq.vm.service.CustomerNumbersService;
import com.zq.vm.repository.specification.CustomerNumbersSpecification;

/**
 * 描述:余额信息业务实现 
 * Time: 2019-02-24 18:46:04
 * @author: zou.qian
 * @version 1.0
 */
@Service
public class CustomerNumbersServiceImpl extends BaseServiceImpl<CustomerNumbers, String> implements CustomerNumbersService{

	@Autowired
	private CustomerNumbersRepository customerNumbersRepository;
	
    @Override
    public void delete(String id) {
        customerNumbersRepository.deleteById(id);
    }

    @Override
    public CustomerNumbers findOne(String id) {
        return customerNumbersRepository.findById(id).orElse(new CustomerNumbers());
    }

    @Override
    public CustomerNumbers save(CustomerNumbers customerNumbers) {
        return customerNumbersRepository.save(customerNumbers);
    }

    @Override
    public Page<CustomerNumbers> findPageByCriteria(int pageNumber, int pageSize, final CustomerNumbers customerNumbers) {
    	return customerNumbersRepository.findAll(CustomerNumbersSpecification.specification(customerNumbers), buildPageRequest(pageNumber, pageSize));
    }
}
