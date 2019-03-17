package com.zq.vm.repository;

import com.zq.vm.entity.ProductStockOut;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 描述: 余额信息业务数据访问类
 * Time: 2019-02-24 18:58:30
 * @author: zou.qian
 * @version 1.0
 */
public interface ProductStockOutRepository extends PagingAndSortingRepository<ProductStockOut,String>, JpaSpecificationExecutor<ProductStockOut> {


}
