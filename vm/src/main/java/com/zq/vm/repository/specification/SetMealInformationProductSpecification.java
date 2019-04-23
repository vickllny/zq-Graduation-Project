package com.zq.vm.repository.specification;

import  com.zq.vm.entity.SetMealInformationProduct;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Optional;

/**
 * 套餐商品信息表条件查询
 */
public class SetMealInformationProductSpecification {

    /**
     * 默认条件查询
     * @param setMealInformationProduct
     * @return
     */
    public static Specification<SetMealInformationProduct> specification(final SetMealInformationProduct setMealInformationProduct){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
            Optional.ofNullable(setMealInformationProduct.getSetMealInformationId()).ifPresent(setMealInformationId -> predicates.add(criteriaBuilder.equal(root.get("setMealInformationId").as(String.class), setMealInformationId)));
            Optional.ofNullable(setMealInformationProduct.getProductId()).ifPresent(productId -> predicates.add(criteriaBuilder.equal(root.get("productId").as(String.class), productId)));
            Optional.ofNullable(setMealInformationProduct.getCount()).ifPresent(count -> predicates.add(criteriaBuilder.equal(root.get("count").as(String.class), count)));
            Optional.ofNullable(setMealInformationProduct.getType()).ifPresent(type -> predicates.add(criteriaBuilder.equal(root.get("type").as(String.class), type)));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}