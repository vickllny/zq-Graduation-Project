package com.zq.vm.service;

import com.zq.vm.entity.ProductInformation;

import org.springframework.data.domain.Page;

/**
 * 描述: 余额信息业务接口
 * Time: 2019-02-24 18:53:33
 * @author: zou.qian
 * @version 1.0
 */
public interface ProductInformationService{

    /**
     * 保存
     * @param productInformation
     * @return
     */
	ProductInformation save(ProductInformation productInformation);

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
     * @param productInformation
     * @return
     */
    Page<ProductInformation> findPageByCriteria(int pageNumber, int pageSize, ProductInformation productInformation);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	ProductInformation findOne(String id);

}
