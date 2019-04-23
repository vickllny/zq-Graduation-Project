package com.zq.vm.repository.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import  com.zq.vm.entity.ProductStock;

/**
 * 商品库存条件查询
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
            Optional.ofNullable(productStock.getProductId()).ifPresent(productId -> predicates.add(criteriaBuilder.equal(root.get("productId").as(String.class), productId)));
            Optional.ofNullable(productStock.getProductStockNumber()).ifPresent(productStockNumber -> predicates.add(criteriaBuilder.equal(root.get("productStockNumber").as(String.class), productStockNumber)));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}