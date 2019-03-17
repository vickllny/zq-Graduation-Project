package com.zq.vm.service.impl;

import com.zq.vm.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.Customer;
import com.zq.vm.service.CustomerService;
import com.zq.vm.repository.specification.CustomerSpecification;

/**
 * 描述:会员信息业务实现 
 * Time: 2019-02-24 14:58:24
 * @author: zou.qian
 * @version 1.0
 */
@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer, String> implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findOne(String id) {
        return customerRepository.findById(id).orElse(new Customer());
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Page<Customer> findPageByCriteria(int pageNumber, int pageSize, final Customer customer) {
    	return customerRepository.findAll(CustomerSpecification.specification(customer), buildPageRequest(pageNumber, pageSize));
    }
}
