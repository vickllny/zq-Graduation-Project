package com.zq.vm.service.impl;

import com.zq.vm.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.Customer;
import com.zq.vm.service.CustomerService;
import com.zq.vm.repository.specification.CustomerSpecification;

import java.util.List;

/**
 * 描述:会员业务实现 
 * Time: 2019-03-25 14:23:23
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

    @Override
    public List<Customer> findAll() {
        return super.findList(customerRepository.findAll());
    }

	@Override
	public List<Customer> findCustomersByStatus(int flag) {
		return customerRepository.findAll(CustomerSpecification.statusSpecification(flag));
	}

	@Override
	public Page<Customer> findPageByCreateTime(Integer pageNumber, Integer pageSize, String createTime) {
		if(StringUtils.isBlank(createTime)) {
			return findPageByCriteria(pageNumber, pageSize, new Customer());
		}
		String startTime = createTime + "-1 00:00:00";
		String endTime = createTime + "-31 00:00:00";
		return customerRepository.findPageByCreateTimeBetween(startTime, endTime, buildPageRequest(pageNumber, pageSize));
	}
}
