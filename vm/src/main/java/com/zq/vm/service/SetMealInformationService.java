package com.zq.vm.service;

import com.zq.vm.entity.SetMealInformation;

import org.springframework.data.domain.Page;

/**
 * 描述: 余额信息业务接口
 * Time: 2019-02-24 19:05:19
 * @author: zou.qian
 * @version 1.0
 */
public interface SetMealInformationService{

    /**
     * 保存
     * @param setMealInformation
     * @return
     */
	SetMealInformation save(SetMealInformation setMealInformation);

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
     * @param setMealInformation
     * @return
     */
    Page<SetMealInformation> findPageByCriteria(int pageNumber, int pageSize, SetMealInformation setMealInformation);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	SetMealInformation findOne(String id);

}
