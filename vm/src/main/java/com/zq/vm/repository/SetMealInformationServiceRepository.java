package com.zq.vm.repository;

import com.zq.vm.entity.SetMealInformationService;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 描述: 余额信息业务数据访问类
 * Time: 2019-02-24 19:09:31
 * @author: zou.qian
 * @version 1.0
 */
public interface SetMealInformationServiceRepository extends PagingAndSortingRepository<SetMealInformationService,String>, JpaSpecificationExecutor<SetMealInformationService> {


}
