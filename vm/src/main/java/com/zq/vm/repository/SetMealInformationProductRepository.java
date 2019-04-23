package com.zq.vm.repository;

import com.zq.vm.entity.SetMealInformationProduct;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 描述: 套餐商品信息表业务数据访问类
 * Time: 2019-04-21 17:12:30
 * @author: zou.qian
 * @version 1.0
 */
public interface SetMealInformationProductRepository extends PagingAndSortingRepository<SetMealInformationProduct,String>, JpaSpecificationExecutor<SetMealInformationProduct> {

	/**
	 * 根据套餐id删除
	 * @param id
	 */
	void deleteBySetMealInformationId(String id);

	/**
	 * 根据套餐id查询选择的商品
	 * @param id
	 * @return
	 */
	List<SetMealInformationProduct> findBySetMealInformationId(String id);

}
