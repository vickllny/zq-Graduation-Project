package com.zq.vm.repository;

import com.zq.vm.entity.ProductStock;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * 描述: 商品库存业务数据访问类
 * Time: 2019-04-13 14:48:40
 * @author: zou.qian
 * @version 1.0
 */
public interface ProductStockRepository extends PagingAndSortingRepository<ProductStock,String>, JpaSpecificationExecutor<ProductStock> {

	/**
	 * 根据商品名称模糊查询
	 * @param name
	 * @param buildPageRequest
	 * @return
	 */
	@Query(value = "select s.* from product_stock s left join product_information i on i.id = s.product_id where 1=1 and i.name like :name order by s.create_time desc", nativeQuery = true)
	Page<ProductStock> findPageByProductName(@Param(value = "name")String name, Pageable pageable);

	/**
	 * 根据产品id查询
	 * @param productId
	 * @return
	 */
	List<ProductStock> findByProductId(String productId);

}
