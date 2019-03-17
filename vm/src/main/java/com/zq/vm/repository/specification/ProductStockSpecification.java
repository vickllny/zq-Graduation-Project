package com.zq.vm.repository.specification;

import  com.zq.vm.entity.ProductStock;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * 余额信息条件查询
 */
public class ProductStockSpecification {

    /**
     * 默认条件查询
     * @param productStock
     * @return
     */
    public static Specification<ProductStock> specification(final ProductStock productStock){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(criteriaBuilder.equal(root.get("productId").as(String.class), productStock.getProductId()));
			predicates.add(criteriaBuilder.equal(root.get("productStockNumber").as(Integer.class), productStock.getProductStockNumber()));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}