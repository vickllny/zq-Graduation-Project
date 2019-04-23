package com.zq.vm.repository;

import com.zq.vm.entity.Customer;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 描述: 会员业务数据访问类
 * Time: 2019-03-25 14:23:23
 * @author: zou.qian
 * @version 1.0
 */
public interface CustomerRepository extends PagingAndSortingRepository<Customer,String>, JpaSpecificationExecutor<Customer> {


}
