package com.zq.vm.repository;

import com.zq.vm.entity.Balance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * 描述: 余额业务数据访问类
 * Time: 2019-03-25 13:45:13
 * @author: zou.qian
 * @version 1.0
 */
public interface BalanceRepository extends PagingAndSortingRepository<Balance,String>, JpaSpecificationExecutor<Balance> {

	/**
	 * 根据会员id查询
	 * @param customerId
	 * @return
	 */
	Balance findByCustomerId(String customerId);

	/**
	 * 根据会员名称模糊查询
	 * @param customerName
	 * @param buildPageRequest
	 * @return
	 */
	@Query(nativeQuery = true,value = "select b.* from balance b left join customer c on c.id = b.customer_id where 1=1 and c.name like :name")
	Page<Balance> findPage(@Param("name")String customerName, Pageable pageable);

}
