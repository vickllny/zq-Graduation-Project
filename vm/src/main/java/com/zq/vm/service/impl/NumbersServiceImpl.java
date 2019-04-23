package com.zq.vm.service.impl;

import com.zq.vm.repository.NumbersRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.Numbers;
import com.zq.vm.service.NumbersService;
import com.zq.vm.repository.specification.NumbersSpecification;

import java.util.List;

/**
 * 描述:会员次数记录表业务实现 
 * Time: 2019-04-20 21:55:56
 * @author: zou.qian
 * @version 1.0
 */
@Service
@Transactional
public class NumbersServiceImpl extends BaseServiceImpl<Numbers, String> implements NumbersService{

	@Autowired
	private NumbersRepository numbersRepository;
	
    @Override
    public void delete(String id) {
        numbersRepository.deleteById(id);
    }

    @Override
    public Numbers findOne(String id) {
        return numbersRepository.findById(id).orElse(new Numbers());
    }

    @Override
    public Numbers save(Numbers numbers) {
    	//查询相关记录是否存在
    	Numbers numbers1 = numbersRepository.findByCustomerIdAndServiceId(numbers.getCustomerId(), numbers.getServiceId());
    	if(numbers1 == null) {
    		numbers1 = numbers;
    	}else {
    		numbers1.setNumbers(numbers1.getNumbers() + numbers.getNumbers());
    	}
    	return numbersRepository.save(numbers1);
    }

    @Override
    public Page<Numbers> findPageByCriteria(int pageNumber, int pageSize, final Numbers numbers) {
    	return numbersRepository.findAll(NumbersSpecification.specification(numbers), buildPageRequest(pageNumber, pageSize));
    }

    @Override
    public List<Numbers> findAll() {
        return super.findList(numbersRepository.findAll());
    }

	@Override
	public Numbers findByCustomerIdAndServiceId(String customerId, String serviceId) {
		return numbersRepository.findByCustomerIdAndServiceId(customerId, serviceId);
	}

	@Override
	public Numbers update(Numbers numbers) {
		return numbersRepository.save(numbers);
	}
}
