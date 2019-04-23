package com.zq.vm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zq.vm.entity.Numbers;
import com.zq.vm.entity.NumbersSpendRecord;
import com.zq.vm.repository.NumbersSpendRecordRepository;
import com.zq.vm.repository.specification.NumbersSpendRecordSpecification;
import com.zq.vm.service.NumbersService;
import com.zq.vm.service.NumbersSpendRecordService;

/**
 * 描述:服务次数消费记录表业务实现 
 * Time: 2019-04-20 20:55:46
 * @author: zou.qian
 * @version 1.0
 */
@Service
@Transactional
public class NumbersSpendRecordServiceImpl extends BaseServiceImpl<NumbersSpendRecord, String> implements NumbersSpendRecordService{

	@Autowired
	private NumbersSpendRecordRepository numbersSpendRecordRepository;
	@Autowired
	private NumbersService numbersService;
	
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

    @Override
    public List<NumbersSpendRecord> findAll() {
        return super.findList(numbersSpendRecordRepository.findAll());
    }

	@Override
	public void saveAndDeductionNumbers(NumbersSpendRecord numbersSpendRecord) {
		numbersSpendRecordRepository.save(numbersSpendRecord);
		//查询次数 如果不够抛出异常
		Numbers numbers = numbersService.findByCustomerIdAndServiceId(numbersSpendRecord.getCustomerId(), numbersSpendRecord.getServiceId());
		if(numbers == null) {
			throw new RuntimeException("操作失败，未查询到充值信息");
		}
		if(numbers.getNumbers() - numbersSpendRecord.getSpendNumbers() < 1) {
			throw new RuntimeException("操作失败，账户次数不足");
		}
		numbers.setNumbers(numbers.getNumbers() - numbersSpendRecord.getSpendNumbers());
		//扣除次数
		numbersService.update(numbers);
	}
}
