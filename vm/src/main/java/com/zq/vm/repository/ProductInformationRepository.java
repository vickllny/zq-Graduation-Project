package com.zq.vm.repository;

import com.zq.vm.entity.ProductInformation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * 描述: 商品信息业务数据访问类
 * Time: 2019-04-13 14:55:42
 * @author: zou.qian
 * @version 1.0
 */
public interface ProductInformationRepository extends PagingAndSortingRepository<ProductInformation,String>, JpaSpecificationExecutor<ProductInformation> {

	/**
	 * 商品业务排行分页查询
	 * @param productName
	 * @param buildPageRequest
	 * @return
	 */
	@Query(value = "select p.id,p.name,temp.count from (select product_id,SUM(count) as count from amount_spend_record GROUP BY product_id) temp\n" + 
			"LEFT JOIN product_information p on p.id = temp.product_id where p.name like :productName ORDER BY temp.count desc",
			countQuery = "select count(1) from (select product_id,SUM(count) as count from amount_spend_record GROUP BY product_id) temp\n" + 
					"LEFT JOIN product_information p on p.id = temp.product_id where p.name like :productName ORDER BY temp.count desc",
					nativeQuery = true)
	Page<Object[]> findRankPage(@Param(value = "productName") String productName, Pageable pageable);


}
