package com.zq.vm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.zq.vm.entity.SetMealInformationService;
import com.zq.vm.repository.SetMealInformationServiceRepository;
import com.zq.vm.repository.specification.SetMealInformationServiceSpecification;
import com.zq.vm.service.SetMealInformationServiceService;

/**
 * 描述:余额信息业务实现 
 * Time: 2019-02-24 19:09:31
 * @author: zou.qian
 * @version 1.0
 */
@Service
public class SetMealInformationServiceServiceImpl extends BaseServiceImpl<SetMealInformationService,String> implements SetMealInformationServiceService{

	@Autowired
	private SetMealInformationServiceRepository setMealInformationServiceRepository;
	
    @Override
    public void delete(String id) {
        setMealInformationServiceRepository.deleteById(id);
    }

    @Override
    public SetMealInformationService findOne(String id) {
        return setMealInformationServiceRepository.findById(id).orElse(new SetMealInformationService());
    }

    @Override
    public SetMealInformationService save(SetMealInformationService setMealInformationService) {
        return setMealInformationServiceRepository.save(setMealInformationService);
    }

    @Override
    public Page<SetMealInformationService> findPageByCriteria(int pageNumber, int pageSize, final SetMealInformationService setMealInformationService) {
    	return setMealInformationServiceRepository.findAll(SetMealInformationServiceSpecification.specification(setMealInformationService), buildPageRequest(pageNumber, pageSize));
    }
}
