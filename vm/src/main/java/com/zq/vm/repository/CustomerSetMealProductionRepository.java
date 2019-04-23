package com.zq.vm.repository;

import com.zq.vm.entity.CustomerSetMealProduction;
import com.zq.vm.entity.SetMealInformationProduct;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 描述: 会员套餐商品关系表业务数据访问类
 * Time: 2019-04-23 22:04:24
 * @author: zou.qian
 * @version 1.0
 */
public interface CustomerSetMealProductionRepository extends PagingAndSortingRepository<CustomerSetMealProduction,String>, JpaSpecificationExecutor<CustomerSetMealProduction> {

	/**
	 * 获取已购套餐下的商品
	 * @param customerSetMealId
	 * @return
	 */
	List<CustomerSetMealProduction> findByCustomerSetMealId(String customerSetMealId);


}
