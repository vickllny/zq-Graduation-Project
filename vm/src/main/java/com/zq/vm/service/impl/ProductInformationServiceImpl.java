package com.zq.vm.service.impl;

import com.zq.vm.repository.ProductInformationRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.ProductInformation;
import com.zq.vm.service.ProductInformationService;
import com.zq.vm.repository.specification.ProductInformationSpecification;

import java.util.List;

/**
 * 描述:商品信息业务实现 
 * Time: 2019-04-13 14:55:42
 * @author: zou.qian
 * @version 1.0
 */
@Service
public class ProductInformationServiceImpl extends BaseServiceImpl<ProductInformation, String> implements ProductInformationService{

	@Autowired
	private ProductInformationRepository productInformationRepository;
	
    @Override
    public void delete(String id) {
        productInformationRepository.deleteById(id);
    }

    @Override
    public ProductInformation findOne(String id) {
        return productInformationRepository.findById(id).orElse(new ProductInformation());
    }

    @Override
    public ProductInformation save(ProductInformation productInformation) {
        return productInformationRepository.save(productInformation);
    }

    @Override
    public Page<ProductInformation> findPageByCriteria(int pageNumber, int pageSize, final ProductInformation productInformation) {
    	return productInformationRepository.findAll(ProductInformationSpecification.specification(productInformation), buildPageRequest(pageNumber, pageSize));
    }

    @Override
    public List<ProductInformation> findAll() {
        return super.findList(productInformationRepository.findAll());
    }
}
