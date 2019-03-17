package com.zq.vm.repository.specification;

import  com.zq.vm.entity.ProductInformation;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 余额信息条件查询
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
			predicates.add(criteriaBuilder.equal(root.get("productId").as(String.class), productInformation.getProductId()));
			predicates.add(criteriaBuilder.equal(root.get("purchasePrice").as(BigDecimal.class), productInformation.getPurchasePrice()));
			predicates.add(criteriaBuilder.equal(root.get("sellingPrice").as(BigDecimal.class), productInformation.getSellingPrice()));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}