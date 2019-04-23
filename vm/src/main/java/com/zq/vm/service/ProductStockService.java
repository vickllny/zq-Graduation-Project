package com.zq.vm.service;

import com.zq.vm.entity.ProductStock;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 描述: 商品库存业务接口
 * Time: 2019-04-13 14:48:40
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

    /**
     * 查询所有
     * @return
     */
    List<ProductStock> findAll();

    /**
     * 根据商品名称查询
     * @param pageNumber
     * @param pageSize
     * @param name
     * @return
     */
	Page<ProductStock> findPageByProductName(Integer pageNumber, Integer pageSize, String name);

	/**
	 * 根据产品id查询
	 * @param productId
	 * @return
	 */
	List<ProductStock> findByProductId(String productId);
}
