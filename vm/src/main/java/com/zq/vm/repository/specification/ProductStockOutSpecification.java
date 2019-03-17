package com.zq.vm.repository.specification;

import  com.zq.vm.entity.ProductStockOut;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 余额信息条件查询
 */
public class ProductStockOutSpecification {

    /**
     * 默认条件查询
     * @param productStockOut
     * @return
     */
    public static Specification<ProductStockOut> specification(final ProductStockOut productStockOut){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(criteriaBuilder.equal(root.get("productId").as(String.class), productStockOut.getProductId()));
			predicates.add(criteriaBuilder.equal(root.get("productOutNumber").as(Integer.class), productStockOut.getProductOutNumber()));
			predicates.add(criteriaBuilder.equal(root.get("productOutPeople").as(String.class), productStockOut.getProductOutPeople()));
			predicates.add(criteriaBuilder.equal(root.get("productOutTime").as(Date.class), productStockOut.getProductOutTime()));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}