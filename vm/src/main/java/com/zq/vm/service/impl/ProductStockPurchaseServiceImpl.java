package com.zq.vm.service.impl;

import com.zq.vm.repository.ProductStockPurchaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.ProductStockPurchase;
import com.zq.vm.service.ProductStockPurchaseService;
import com.zq.vm.repository.specification.ProductStockPurchaseSpecification;

/**
 * 描述:余额信息业务实现 
 * Time: 2019-02-24 19:00:38
 * @author: zou.qian
 * @version 1.0
 */
@Service
public class ProductStockPurchaseServiceImpl extends BaseServiceImpl<ProductStockPurchase, String> implements ProductStockPurchaseService{

	@Autowired
	private ProductStockPurchaseRepository productStockPurchaseRepository;
	
    @Override
    public void delete(String id) {
        productStockPurchaseRepository.deleteById(id);
    }

    @Override
    public ProductStockPurchase findOne(String id) {
        return productStockPurchaseRepository.findById(id).orElse(new ProductStockPurchase());
    }

    @Override
    public ProductStockPurchase save(ProductStockPurchase productStockPurchase) {
        return productStockPurchaseRepository.save(productStockPurchase);
    }

    @Override
    public Page<ProductStockPurchase> findPageByCriteria(int pageNumber, int pageSize, final ProductStockPurchase productStockPurchase) {
    	return productStockPurchaseRepository.findAll(ProductStockPurchaseSpecification.specification(productStockPurchase), buildPageRequest(pageNumber, pageSize));
    }
}
