package com.zq.vm.service;

import com.zq.vm.entity.ServiceInformation;

import org.springframework.data.domain.Page;

/**
 * 描述: 余额信息业务接口
 * Time: 2019-02-24 19:02:59
 * @author: zou.qian
 * @version 1.0
 */
public interface ServiceInformationService{

    /**
     * 保存
     * @param serviceInformation
     * @return
     */
	ServiceInformation save(ServiceInformation serviceInformation);

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
     * @param serviceInformation
     * @return
     */
    Page<ServiceInformation> findPageByCriteria(int pageNumber, int pageSize, ServiceInformation serviceInformation);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	ServiceInformation findOne(String id);

}
