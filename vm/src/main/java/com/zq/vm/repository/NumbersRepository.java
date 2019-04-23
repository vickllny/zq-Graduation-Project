package com.zq.vm.repository;

import com.zq.vm.entity.Numbers;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 描述: 会员次数记录表业务数据访问类
 * Time: 2019-04-20 21:55:56
 * @author: zou.qian
 * @version 1.0
 */
public interface NumbersRepository extends PagingAndSortingRepository<Numbers,String>, JpaSpecificationExecutor<Numbers> {

	/**
	 * 根据会员id和服务id查询次数
	 * @param customerId
	 * @param serviceId
	 * @return
	 */
	Numbers findByCustomerIdAndServiceId(String customerId, String serviceId);


}
