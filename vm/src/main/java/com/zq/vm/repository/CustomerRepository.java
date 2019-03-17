package com.zq.vm.repository;

import com.zq.vm.entity.Customer;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 描述: 会员信息业务数据访问类
 * Time: 2019-02-24 14:58:24
 * @author: zou.qian
 * @version 1.0
 */
public interface CustomerRepository extends PagingAndSortingRepository<Customer,String>, JpaSpecificationExecutor<Customer> {


}
