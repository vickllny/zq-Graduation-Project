package com.zq.vm.repository;

import com.zq.vm.entity.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * 描述: 会员业务数据访问类
 * Time: 2019-03-25 14:23:23
 * @author: zou.qian
 * @version 1.0
 */
public interface CustomerRepository extends PagingAndSortingRepository<Customer,String>, JpaSpecificationExecutor<Customer> {

	/**
	 * 根据开始时间和结束时间查询
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@Query(value = "select * from customer where 1=1 and create_time between :startTime and :endTime",
			countQuery = "select count(1) from customer where 1=1 and create_time between :startTime and :endTime", nativeQuery = true)
	Page<Customer> findPageByCreateTimeBetween(@Param(value = "startTime")String startTime,@Param(value = "endTime") String endTime, Pageable pageable);

}
