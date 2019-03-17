package com.zq.vm.service.impl;

import com.zq.vm.repository.ProductStockOutRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.ProductStockOut;
import com.zq.vm.service.ProductStockOutService;
import com.zq.vm.repository.specification.ProductStockOutSpecification;

/**
 * 描述:余额信息业务实现 
 * Time: 2019-02-24 18:58:30
 * @author: zou.qian
 * @version 1.0
 */
@Service
public class ProductStockOutServiceImpl extends BaseServiceImpl<ProductStockOut, String> implements ProductStockOutService{

	@Autowired
	private ProductStockOutRepository productStockOutRepository;
	
    @Override
    public void delete(String id) {
        productStockOutRepository.deleteById(id);
    }

    @Override
    public ProductStockOut findOne(String id) {
        return productStockOutRepository.findById(id).orElse(new ProductStockOut());
    }

    @Override
    public ProductStockOut save(ProductStockOut productStockOut) {
        return productStockOutRepository.save(productStockOut);
    }

    @Override
    public Page<ProductStockOut> findPageByCriteria(int pageNumber, int pageSize, final ProductStockOut productStockOut) {
    	return productStockOutRepository.findAll(ProductStockOutSpecification.specification(productStockOut), buildPageRequest(pageNumber, pageSize));
    }
}
