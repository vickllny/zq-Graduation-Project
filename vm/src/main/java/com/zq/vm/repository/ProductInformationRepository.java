package com.zq.vm.repository;

import com.zq.vm.entity.ProductInformation;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 描述: 商品信息业务数据访问类
 * Time: 2019-04-13 14:55:42
 * @author: zou.qian
 * @version 1.0
 */
public interface ProductInformationRepository extends PagingAndSortingRepository<ProductInformation,String>, JpaSpecificationExecutor<ProductInformation> {


}
