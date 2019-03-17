package com.zq.vm.service;

import com.zq.vm.entity.ProductStockPurchase;

import org.springframework.data.domain.Page;

/**
 * 描述: 余额信息业务接口
 * Time: 2019-02-24 19:00:38
 * @author: zou.qian
 * @version 1.0
 */
public interface ProductStockPurchaseService{

    /**
     * 保存
     * @param productStockPurchase
     * @return
     */
	ProductStockPurchase save(ProductStockPurchase productStockPurchase);

    /**
     * 删除
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param productStockPurchase
     * @return
     */
    Page<ProductStockPurchase> findPageByCriteria(int pageNumber, int pageSize, ProductStockPurchase productStockPurchase);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	ProductStockPurchase findOne(String id);

}
