package com.zq.vm.service.impl;

import com.zq.vm.repository.ServiceInformationRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.ServiceInformation;
import com.zq.vm.service.ServiceInformationService;
import com.zq.vm.repository.specification.ServiceInformationSpecification;

/**
 * 描述:余额信息业务实现 
 * Time: 2019-02-24 19:02:59
 * @author: zou.qian
 * @version 1.0
 */
@Service
public class ServiceInformationServiceImpl extends BaseServiceImpl<ServiceInformation, String> implements ServiceInformationService{

	@Autowired
	private ServiceInformationRepository serviceInformationRepository;
	
    @Override
    public void delete(String id) {
        serviceInformationRepository.deleteById(id);
    }

    @Override
    public ServiceInformation findOne(String id) {
        return serviceInformationRepository.findById(id).orElse(new ServiceInformation());
    }

    @Override
    public ServiceInformation save(ServiceInformation serviceInformation) {
        return serviceInformationRepository.save(serviceInformation);
    }

    @Override
    public Page<ServiceInformation> findPageByCriteria(int pageNumber, int pageSize, final ServiceInformation serviceInformation) {
    	return serviceInformationRepository.findAll(ServiceInformationSpecification.specification(serviceInformation), buildPageRequest(pageNumber, pageSize));
    }
}
