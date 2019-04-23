package com.zq.vm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.zq.vm.entity.AmountSpendRecord;

/**
 * 描述: 余额充值记录业务数据访问类
 * Time: 2019-03-23 13:44:04
 * @author: zou.qian
 * @version 1.0
 */
public interface AmountSpendRecordRepository extends PagingAndSortingRepository<AmountSpendRecord,String>, JpaSpecificationExecutor<AmountSpendRecord> {

	@Query(value = "select r.* from amount_spend_record r left join product_information p on p.id = r.product_id left join customer c on c.id = r.customer_id where 1=1 and p.name like :productName and c.name like :customerName order by r.spend_time desc"
			,countQuery = "select count(1) from amount_spend_record r left join product_information p on p.id = r.product_id left join customer c on c.id = r.customer_id where 1=1 and p.name like :productName and c.name like :customerName", nativeQuery = true)
	Page<AmountSpendRecord> findSearchPage(@Param(value = "customerName")String customerName,@Param(value = "productName") String productName, Pageable pageable);

}
