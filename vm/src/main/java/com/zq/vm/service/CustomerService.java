package com.zq.vm.service;


import com.zq.vm.entity.Customer;
import org.springframework.data.domain.Page;

/**
 * 描述: 会员信息业务接口
 * Time: 2019-02-24 14:58:24
 * @author: zou.qian
 * @version 1.0
 */
public interface CustomerService{

    /**
     * 保存
     * @param customer
     * @return
     */
	Customer save(Customer customer);

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
     * @param customer
     * @return
     */
    Page<Customer> findPageByCriteria(int pageNumber, int pageSize, Customer customer);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	Customer findOne(String id);

}
