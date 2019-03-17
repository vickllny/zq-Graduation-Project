package com.zq.vm.service;

import com.zq.vm.entity.SetMealInformationProduct;

import org.springframework.data.domain.Page;

/**
 * 描述: 余额信息业务接口
 * Time: 2019-02-24 19:07:37
 * @author: zou.qian
 * @version 1.0
 */
public interface SetMealInformationProductService{

    /**
     * 保存
     * @param setMealInformationProduct
     * @return
     */
	SetMealInformationProduct save(SetMealInformationProduct setMealInformationProduct);

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
     * @param setMealInformationProduct
     * @return
     */
    Page<SetMealInformationProduct> findPageByCriteria(int pageNumber, int pageSize, SetMealInformationProduct setMealInformationProduct);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	SetMealInformationProduct findOne(String id);

}
