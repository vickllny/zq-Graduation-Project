package com.zq.vm.service;

import com.zq.vm.entity.SetMealInformationService;

import org.springframework.data.domain.Page;

/**
 * 描述: 余额信息业务接口
 * Time: 2019-02-24 19:09:31
 * @author: zou.qian
 * @version 1.0
 */
public interface SetMealInformationServiceService{

    /**
     * 保存
     * @param setMealInformationService
     * @return
     */
	SetMealInformationService save(SetMealInformationService setMealInformationService);

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
     * @param setMealInformationService
     * @return
     */
    Page<SetMealInformationService> findPageByCriteria(int pageNumber, int pageSize, SetMealInformationService setMealInformationService);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	SetMealInformationService findOne(String id);

}
