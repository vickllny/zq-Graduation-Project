package com.zq.vm.repository.specification;

import  com.zq.vm.entity.CustomerSetMealProduction;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Optional;

/**
 * 会员套餐商品关系表条件查询
 */
public class CustomerSetMealProductionSpecification {

    /**
     * 默认条件查询
     * @param customerSetMealProduction
     * @return
     */
    public static Specification<CustomerSetMealProduction> specification(final CustomerSetMealProduction customerSetMealProduction){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
            Optional.ofNullable(customerSetMealProduction.getCustomerId()).ifPresent(customerId -> predicates.add(criteriaBuilder.equal(root.get("customerId").as(String.class), customerId)));
            Optional.ofNullable(customerSetMealProduction.getSetMealId()).ifPresent(setMealId -> predicates.add(criteriaBuilder.equal(root.get("setMealId").as(String.class), setMealId)));
            Optional.ofNullable(customerSetMealProduction.getCustomerSetMealId()).ifPresent(customerSetMealId -> predicates.add(criteriaBuilder.equal(root.get("customerSetMealId").as(String.class), customerSetMealId)));
            Optional.ofNullable(customerSetMealProduction.getProductId()).ifPresent(productId -> predicates.add(criteriaBuilder.equal(root.get("productId").as(String.class), productId)));
            Optional.ofNullable(customerSetMealProduction.getType()).ifPresent(type -> predicates.add(criteriaBuilder.equal(root.get("type").as(String.class), type)));
            Optional.ofNullable(customerSetMealProduction.getCount()).ifPresent(count -> predicates.add(criteriaBuilder.equal(root.get("count").as(String.class), count)));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}