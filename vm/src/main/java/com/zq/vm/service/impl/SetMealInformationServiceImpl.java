package com.zq.vm.service.impl;

import com.zq.vm.repository.SetMealInformationRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.SetMealInformation;
import com.zq.vm.service.SetMealInformationService;
import com.zq.vm.repository.specification.SetMealInformationSpecification;

/**
 * 描述:余额信息业务实现 
 * Time: 2019-02-24 19:05:19
 * @author: zou.qian
 * @version 1.0
 */
@Service
public class SetMealInformationServiceImpl extends BaseServiceImpl<SetMealInformation,String> implements SetMealInformationService{

	@Autowired
	private SetMealInformationRepository setMealInformationRepository;
	
    @Override
    public void delete(String id) {
        setMealInformationRepository.deleteById(id);
    }

    @Override
    public SetMealInformation findOne(String id) {
        return setMealInformationRepository.findById(id).orElse(new SetMealInformation());
    }

    @Override
    public SetMealInformation save(SetMealInformation setMealInformation) {
        return setMealInformationRepository.save(setMealInformation);
    }

    @Override
    public Page<SetMealInformation> findPageByCriteria(int pageNumber, int pageSize, final SetMealInformation setMealInformation) {
    	return setMealInformationRepository.findAll(SetMealInformationSpecification.specification(setMealInformation), buildPageRequest(pageNumber, pageSize));
    }
}
