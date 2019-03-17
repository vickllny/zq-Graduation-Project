package com.zq.vm.repository;

import com.zq.vm.entity.ProductStockPurchase;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 描述: 余额信息业务数据访问类
 * Time: 2019-02-24 19:00:38
 * @author: zou.qian
 * @version 1.0
 */
public interface ProductStockPurchaseRepository extends PagingAndSortingRepository<ProductStockPurchase,String>, JpaSpecificationExecutor<ProductStockPurchase> {


}
