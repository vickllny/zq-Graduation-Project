package com.zq.vm.service;

import com.zq.vm.entity.ProductStock;

import org.springframework.data.domain.Page;

/**
 * 描述: 余额信息业务接口
 * Time: 2019-02-24 18:55:51
 * @author: zou.qian
 * @version 1.0
 */
public interface ProductStockService{

    /**
     * 保存
     * @param productStock
     * @return
     */
	ProductStock save(ProductStock productStock);

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
     * @param productStock
     * @return
     */
    Page<ProductStock> findPageByCriteria(int pageNumber, int pageSize, ProductStock productStock);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	ProductStock findOne(String id);

}
