package com.zq.vm.repository.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import  com.zq.vm.entity.ProductInformation;

/**
 * 商品信息条件查询
 */
public class ProductInformationSpecification {

    /**
     * 默认条件查询
     * @param productInformation
     * @return
     */
    public static Specification<ProductInformation> specification(final ProductInformation productInformation){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
            Optional.ofNullable(productInformation.getName()).ifPresent(name -> predicates.add(criteriaBuilder.like(root.get("name").as(String.class), "%"+name+"%")));
            Optional.ofNullable(productInformation.getPurchasePrice()).ifPresent(purchasePrice -> predicates.add(criteriaBuilder.equal(root.get("purchasePrice").as(String.class), purchasePrice)));
            Optional.ofNullable(productInformation.getSellingPrice()).ifPresent(sellingPrice -> predicates.add(criteriaBuilder.equal(root.get("sellingPrice").as(String.class), sellingPrice)));
            Optional.ofNullable(productInformation.getUnit()).ifPresent(unit -> predicates.add(criteriaBuilder.equal(root.get("unit").as(String.class), unit)));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}