package com.zq.vm.repository;

import com.zq.vm.entity.SetMealInformation;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 描述: 套餐管理业务数据访问类
 * Time: 2019-03-25 22:25:50
 * @author: zou.qian
 * @version 1.0
 */
public interface SetMealInformationRepository extends PagingAndSortingRepository<SetMealInformation,String>, JpaSpecificationExecutor<SetMealInformation> {


}
