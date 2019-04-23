package com.zq.vm.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.zq.vm.entity.AmountSpendRecord;
import com.zq.vm.entity.Balance;
import com.zq.vm.entity.ProductInformation;
import com.zq.vm.entity.vo.AmountSpendRecordVo;
import com.zq.vm.repository.AmountSpendRecordRepository;
import com.zq.vm.repository.specification.AmountSpendRecordSpecification;
import com.zq.vm.service.AmountSpendRecordService;
import com.zq.vm.service.BalanceService;
import com.zq.vm.service.ProductInformationService;

/**
 * 描述:余额充值记录业务实现 
 * Time: 2019-03-23 13:44:04
 * @author: zou.qian
 * @version 1.0
 */
@Service
public class AmountSpendRecordServiceImpl extends BaseServiceImpl<AmountSpendRecord, String> implements AmountSpendRecordService{

	@Autowired
	private AmountSpendRecordRepository amountSpendRecordRepository;
    @Autowired
    private ProductInformationService productInformationService;
    @Autowired
    private BalanceService balanceService;
	
    @Override
    public void delete(String id) {
        amountSpendRecordRepository.deleteById(id);
    }

    @Override
    public AmountSpendRecord findOne(String id) {
        return amountSpendRecordRepository.findById(id).orElse(new AmountSpendRecord());
    }

    @Override
    public AmountSpendRecord save(AmountSpendRecord amountSpendRecord) {
    	ProductInformation product = productInformationService.findOne(amountSpendRecord.getProductId());
        AmountSpendRecord save = amountSpendRecordRepository.save(amountSpendRecord);
        //更新库存
        product.setQuantity(product.getQuantity() - save.getCount());
        productInformationService.save(product);
        //更新用户余额
        Balance balance = balanceService.findByCustomerId(save.getCustomerId());
        balance.setBalance(balance.getBalance().subtract(save.getAmountSpend()));
        balanceService.save(balance);
        return save;
    }

    @Override
    public Page<AmountSpendRecord> findPageByCriteria(int pageNumber, int pageSize, final AmountSpendRecord amountSpendRecord) {
    	return amountSpendRecordRepository.findAll(AmountSpendRecordSpecification.specification(amountSpendRecord), buildPageRequest(pageNumber, pageSize));
    }

    @Override
    public List<AmountSpendRecord> findAll() {
        return super.findList(amountSpendRecordRepository.findAll());
    }

	@Override
	public Page<AmountSpendRecord> findPageByCriteria(Integer pageNumber, Integer pageSize,
			AmountSpendRecordVo vo) {
		String customerName = vo != null && StringUtils.isBlank(vo.getCustomerName())?"%%" : "%"+vo.getCustomerName()+"%";
		String productName = vo != null && StringUtils.isBlank(vo.getProductName())?"%%" : "%"+vo.getProductName()+"%";
		return amountSpendRecordRepository.findSearchPage(customerName, productName, buildPageRequest(pageNumber, pageSize));
	}
}
