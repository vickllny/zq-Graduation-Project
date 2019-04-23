package com.zq.vm.service;

import com.zq.vm.entity.ServiceInformation;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 描述: 服务信息表(商品)业务接口
 * Time: 2019-04-16 23:18:35
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

    /**
     * 查询所有
     * @return
     */
    List<ServiceInformation> findAll();
}
