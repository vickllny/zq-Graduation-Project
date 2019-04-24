package com.zq.vm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zq.vm.entity.CustomerSetMealProduction;
import com.zq.vm.entity.ProductInformation;
import com.zq.vm.entity.SetMealInformationProduct;
import com.zq.vm.entity.vo.CustomerSetMealProductionVo;
import com.zq.vm.repository.CustomerSetMealProductionRepository;
import com.zq.vm.repository.specification.CustomerSetMealProductionSpecification;
import com.zq.vm.service.CustomerSetMealProductionService;
import com.zq.vm.service.ProductInformationService;
import com.zq.vm.service.SetMealInformationProductService;

/**
 * 描述:会员套餐商品关系表业务实现 
 * Time: 2019-04-23 22:04:24
 * @author: zou.qian
 * @version 1.0
 */
@Service
@Transactional
public class CustomerSetMealProductionServiceImpl extends BaseServiceImpl<CustomerSetMealProduction, String> implements CustomerSetMealProductionService{

	@Autowired
	private CustomerSetMealProductionRepository customerSetMealProductionRepository;
	@Autowired
	private SetMealInformationProductService setMealInformationProductService;
	@Autowired
	private ProductInformationService productInformationService;
	
    @Override
    public void delete(String id) {
        customerSetMealProductionRepository.deleteById(id);
    }

    @Override
    public CustomerSetMealProduction findOne(String id) {
        return customerSetMealProductionRepository.findById(id).orElse(new CustomerSetMealProduction());
    }

    @Override
    public CustomerSetMealProduction save(CustomerSetMealProduction customerSetMealProduction) {
        return customerSetMealProductionRepository.save(customerSetMealProduction);
    }

    @Override
    public Page<CustomerSetMealProduction> findPageByCriteria(int pageNumber, int pageSize, final CustomerSetMealProduction customerSetMealProduction) {
    	return customerSetMealProductionRepository.findAll(CustomerSetMealProductionSpecification.specification(customerSetMealProduction), buildPageRequest(pageNumber, pageSize));
    }

    @Override
    public List<CustomerSetMealProduction> findAll() {
        return super.findList(customerSetMealProductionRepository.findAll());
    }

	@Override
	public void save(String customerId, String setMealId, String customerSetMealId) {
		List<SetMealInformationProduct> list = setMealInformationProductService.findBySetMealInforamtionId(setMealId);
		for (SetMealInformationProduct product1 : list) {
			CustomerSetMealProduction bean = new CustomerSetMealProduction(customerId, setMealId, customerSetMealId
					, product1.getProductId(), product1.getType(), product1.getCount());
			this.save(bean);
		}
	}

	@Override
	public List<CustomerSetMealProductionVo> findVoByCustomerSetMealId(String customerSetMealId) {
		List<CustomerSetMealProduction> list = customerSetMealProductionRepository.findByCustomerSetMealId(customerSetMealId);
		List<CustomerSetMealProductionVo> vo = new ArrayList<>(list.size());
		list.forEach(bean -> {
			ProductInformation product = productInformationService.findOne(bean.getProductId());
			String productName = product!=null && StringUtils.isNotBlank(product.getName()) ? product.getName() : StringUtils.EMPTY;
			vo.add(CustomerSetMealProductionVo.build(bean, productName));
		});
		return vo;
	}
}
