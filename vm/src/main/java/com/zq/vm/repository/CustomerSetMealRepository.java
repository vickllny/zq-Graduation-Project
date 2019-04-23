package com.zq.vm.repository;

import com.zq.vm.entity.CustomerSetMeal;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 描述: 会员套餐关系表业务数据访问类
 * Time: 2019-04-22 23:40:19
 * @author: zou.qian
 * @version 1.0
 */
@Transactional
public interface CustomerSetMealRepository extends PagingAndSortingRepository<CustomerSetMeal,String>, JpaSpecificationExecutor<CustomerSetMeal> {


}
