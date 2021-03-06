package com.zq.vm.service;

import com.zq.vm.entity.ProductStockOut;

import org.springframework.data.domain.Page;

/**
 * 描述: 余额信息业务接口
 * Time: 2019-02-24 18:58:30
 * @author: zou.qian
 * @version 1.0
 */
public interface ProductStockOutService{

    /**
     * 保存
     * @param productStockOut
     * @return
     */
	ProductStockOut save(ProductStockOut productStockOut);

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
     * @param productStockOut
     * @return
     */
    Page<ProductStockOut> findPageByCriteria(int pageNumber, int pageSize, ProductStockOut productStockOut);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	ProductStockOut findOne(String id);

}
