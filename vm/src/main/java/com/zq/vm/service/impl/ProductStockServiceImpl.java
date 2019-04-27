package com.zq.vm.service.impl;

import com.zq.vm.repository.ProductStockRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.ProductStock;
import com.zq.vm.entity.vo.ProductStockVo;
import com.zq.vm.service.ProductStockService;
import com.zq.vm.repository.specification.ProductStockSpecification;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:商品库存业务实现 
 * Time: 2019-04-13 14:48:40
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

    @Override
    public List<ProductStock> findAll() {
        return super.findList(productStockRepository.findAll());
    }

	@Override
	public Page<ProductStock> findPageByProductName(Integer pageNumber, Integer pageSize, String name) {
		name = StringUtils.isBlank(name)? "%%" : "%"+name+"%";
		return productStockRepository.findPageByProductName(name, buildPageRequest(pageNumber, pageSize));
	}

	@Override
	public List<ProductStock> findByProductId(String productId) {
		return productStockRepository.findByProductId(productId);
	}

	@Override
	public Page<ProductStock> findstatisticsPage(Integer pageNumber, Integer pageSize, ProductStockVo vo) {
		Page<ProductStock> page = productStockRepository.findAll(ProductStockSpecification.findstatisticsSpecification(vo), buildPageRequest(pageNumber, pageSize));
		return page;
	}
}
