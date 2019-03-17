package com.zq.vm.service.impl;

import com.zq.vm.repository.SetMealInformationProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.SetMealInformationProduct;
import com.zq.vm.service.SetMealInformationProductService;
import com.zq.vm.repository.specification.SetMealInformationProductSpecification;

/**
 * 描述:余额信息业务实现 
 * Time: 2019-02-24 19:07:37
 * @author: zou.qian
 * @version 1.0
 */
@Service
public class SetMealInformationProductServiceImpl extends BaseServiceImpl<SetMealInformationProduct, String> implements SetMealInformationProductService{

	@Autowired
	private SetMealInformationProductRepository setMealInformationProductRepository;
	
    @Override
    public void delete(String id) {
        setMealInformationProductRepository.deleteById(id);
    }

    @Override
    public SetMealInformationProduct findOne(String id) {
        return setMealInformationProductRepository.findById(id).orElse(new SetMealInformationProduct());
    }

    @Override
    public SetMealInformationProduct save(SetMealInformationProduct setMealInformationProduct) {
        return setMealInformationProductRepository.save(setMealInformationProduct);
    }

    @Override
    public Page<SetMealInformationProduct> findPageByCriteria(int pageNumber, int pageSize, final SetMealInformationProduct setMealInformationProduct) {
    	return setMealInformationProductRepository.findAll(SetMealInformationProductSpecification.specification(setMealInformationProduct), buildPageRequest(pageNumber, pageSize));
    }
}
