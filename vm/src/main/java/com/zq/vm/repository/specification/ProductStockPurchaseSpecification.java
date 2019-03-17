package com.zq.vm.repository.specification;

import  com.zq.vm.entity.ProductStockPurchase;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 余额信息条件查询
 */
public class ProductStockPurchaseSpecification {

    /**
     * 默认条件查询
     * @param productStockPurchase
     * @return
     */
    public static Specification<ProductStockPurchase> specification(final ProductStockPurchase productStockPurchase){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(criteriaBuilder.equal(root.get("productId").as(String.class), productStockPurchase.getProductId()));
			predicates.add(criteriaBuilder.equal(root.get("productPurchaseNumber").as(Integer.class), productStockPurchase.getProductPurchaseNumber()));
			predicates.add(criteriaBuilder.equal(root.get("productPurchasePeople").as(String.class), productStockPurchase.getProductPurchasePeople()));
			predicates.add(criteriaBuilder.equal(root.get("productPurchaseTime").as(Date.class), productStockPurchase.getProductPurchaseTime()));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}