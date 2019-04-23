package com.zq.vm.repository;

import com.zq.vm.entity.ServiceInformation;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 描述: 服务信息表(商品)业务数据访问类
 * Time: 2019-04-16 23:18:35
 * @author: zou.qian
 * @version 1.0
 */
public interface ServiceInformationRepository extends PagingAndSortingRepository<ServiceInformation,String>, JpaSpecificationExecutor<ServiceInformation> {


}
