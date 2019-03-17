package com.zq.vm.service.impl;

import com.zq.vm.repository.ProductStockRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.ProductStock;
import com.zq.vm.service.ProductStockService;
import com.zq.vm.repository.specification.ProductStockSpecification;

/**
 * 描述:余额信息业务实现 
 * Time: 2019-02-24 18:55:51
 * @author: zou.qian
 * @version 1.0
 */
@Service
public class ProductStockServiceImpl extends BaseServiceImpl<ProductStock, String> implements ProductStockService{

	@Autowired
	private ProductStockRepository productStockRepository;
	
    @Override
    public void delete(String id) {
        productStockRepository.deleteById(id);
    }

    @Override
    public ProductStock findOne(String id) {
        return productStockRepository.findById(id).orElse(new ProductStock());
    }

    @Override
    public ProductStock save(ProductStock productStock) {
        return productStockRepository.save(productStock);
    }

    @Override
    public Page<ProductStock> findPageByCriteria(int pageNumber, int pageSize, final ProductStock productStock) {
    	return productStockRepository.findAll(ProductStockSpecification.specification(productStock), buildPageRequest(pageNumber, pageSize));
    }
}
