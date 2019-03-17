package com.zq.vm.repository;

import com.zq.vm.entity.SetMealInformationProduct;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 描述: 余额信息业务数据访问类
 * Time: 2019-02-24 19:07:37
 * @author: zou.qian
 * @version 1.0
 */
public interface SetMealInformationProductRepository extends PagingAndSortingRepository<SetMealInformationProduct,String>, JpaSpecificationExecutor<SetMealInformationProduct> {


}
