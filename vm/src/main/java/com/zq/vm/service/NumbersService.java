package com.zq.vm.service;

import com.zq.vm.entity.Numbers;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 描述: 会员次数记录表业务接口
 * Time: 2019-04-20 21:55:56
 * @author: zou.qian
 * @version 1.0
 */
public interface NumbersService{

    /**
     * 保存
     * @param numbers
     * @return
     */
	Numbers save(Numbers numbers);
	
    /**
     * 更新
     * @param numbers
     * @return
     */
	Numbers update(Numbers numbers);

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
     * @param numbers
     * @return
     */
    Page<Numbers> findPageByCriteria(int pageNumber, int pageSize, Numbers numbers);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	Numbers findOne(String id);

    /**
     * 查询所有
     * @return
     */
    List<Numbers> findAll();

    /**
     * 根据会员id和服务id查询次数
     * @param customerId
     * @param serviceId
     * @return
     */
	Numbers findByCustomerIdAndServiceId(String customerId, String serviceId);
}
