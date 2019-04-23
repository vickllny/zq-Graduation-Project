package com.zq.vm.service;

import com.zq.vm.entity.ProductInformation;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 描述: 商品信息业务接口
 * Time: 2019-04-13 14:55:42
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

    /**
     * 查询所有
     * @return
     */
    List<ProductInformation> findAll();
}
