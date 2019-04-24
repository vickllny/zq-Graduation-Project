package com.zq.vm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zq.vm.entity.AmountSpendRecord;
import com.zq.vm.entity.Balance;
import com.zq.vm.entity.CustomerSetMeal;
import com.zq.vm.entity.CustomerSetMealProduction;
import com.zq.vm.entity.NumbersSpendRecord;
import com.zq.vm.entity.SetMealInformation;
import com.zq.vm.repository.CustomerSetMealRepository;
import com.zq.vm.repository.specification.CustomerSetMealSpecification;
import com.zq.vm.service.AmountSpendRecordService;
import com.zq.vm.service.BalanceService;
import com.zq.vm.service.CustomerSetMealProductionService;
import com.zq.vm.service.CustomerSetMealService;
import com.zq.vm.service.NumbersSpendRecordService;
import com.zq.vm.service.SetMealInformationService;

/**
 * 描述:会员套餐关系表业务实现 
 * Time: 2019-04-22 23:40:19
 * @author: zou.qian
 * @version 1.0
 */
@Service
@Transactional
public class CustomerSetMealServiceImpl extends BaseServiceImpl<CustomerSetMeal, String> implements CustomerSetMealService{

	@Autowired
	private CustomerSetMealRepository customerSetMealRepository;
	@Autowired
	private BalanceService balanceService;
	@Autowired
	private SetMealInformationService setMealInformationService;
	@Autowired
	private CustomerSetMealProductionService customerSetMealProductionService;
	@Autowired
	private AmountSpendRecordService amountSpendRecordService;
	@Autowired
	private NumbersSpendRecordService numbersSpendRecordService;
	
    @Override
    public void delete(String id) {
        customerSetMealRepository.deleteById(id);
    }

    @Override
    public CustomerSetMeal findOne(String id) {
        return customerSetMealRepository.findById(id).orElse(new CustomerSetMeal());
    }

    @Override
    public CustomerSetMeal save(CustomerSetMeal customerSetMeal) {
        return customerSetMealRepository.save(customerSetMeal);
    }

    @Override
    public Page<CustomerSetMeal> findPageByCriteria(int pageNumber, int pageSize, final CustomerSetMeal customerSetMeal) {
    	return customerSetMealRepository.findAll(CustomerSetMealSpecification.specification(customerSetMeal), buildPageRequest(pageNumber, pageSize));
    }

    @Override
    public List<CustomerSetMeal> findAll() {
        return super.findList(customerSetMealRepository.findAll());
    }

	@Override
	public void saveAndDeduction(CustomerSetMeal customerSetMeal) {
		CustomerSetMeal customerSetMeal1 = this.save(customerSetMeal);
		SetMealInformation setMeal = setMealInformationService.findOne(customerSetMeal1.getSetMealId());
		Date date = new Date();
		if(date.after(setMeal.getMealTimelimit())) {
			throw new RuntimeException("此套餐已经过期，无法使用，请重新选择！");
		}
		Balance balance = balanceService.findByCustomerId(customerSetMeal1.getCustomerId());
		if(balance.getBalance().compareTo(setMeal.getPrice()) == -1) {
			throw new RuntimeException("会员账户余额不足，请充值！");
		}
		balance.setBalance(balance.getBalance().subtract(setMeal.getPrice()));
		balanceService.save(balance);
		//保存会员套餐商品信息
		customerSetMealProductionService.save(customerSetMeal1.getCustomerId(), customerSetMeal1.getSetMealId(), customerSetMeal1.getId());
	}

	@Override
	public void substractProductionCountAndGenRecord(CustomerSetMealProduction customerSetMeal) {
		//套餐商品数量减一
		customerSetMeal.setCount(customerSetMeal.getCount()-1);
		customerSetMealProductionService.save(customerSetMeal);
		
		CustomerSetMeal customerSetMeal1 = this.findOne(customerSetMeal.getCustomerSetMealId());
		//生成消费记录
		if(customerSetMeal.getType().equals("1")) {
			//商品
			AmountSpendRecord record = new AmountSpendRecord();
			record.setCount(1);
			record.setType("2");
			record.setCreateUserId(customerSetMeal1.getCreateUserId());
			record.setCustomerId(customerSetMeal1.getCustomerId());
			record.setProductId(customerSetMeal.getProductId());
			record.setSpendTime(new Date());
			amountSpendRecordService.msave(record);
		}else if(customerSetMeal.getType().equals("2")) {
			//次数
			NumbersSpendRecord record = new NumbersSpendRecord();
			record.setCustomerId(customerSetMeal1.getCustomerId());
			record.setServiceId(customerSetMeal.getProductId());
			record.setSpendNumbers(1);
			record.setSpendTime(new Date());
			record.setType("2");
			numbersSpendRecordService.save(record);
		}
	}
}
