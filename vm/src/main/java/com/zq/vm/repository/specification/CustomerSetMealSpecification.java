package com.zq.vm.repository.specification;

import  com.zq.vm.entity.CustomerSetMeal;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Optional;

/**
 * 会员套餐关系表条件查询
 */
public class CustomerSetMealSpecification {

    /**
     * 默认条件查询
     * @param customerSetMeal
     * @return
     */
    public static Specification<CustomerSetMeal> specification(final CustomerSetMeal customerSetMeal){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
            Optional.ofNullable(customerSetMeal.getCustomerId()).ifPresent(customerId -> predicates.add(criteriaBuilder.equal(root.get("customerId").as(String.class), customerId)));
            Optional.ofNullable(customerSetMeal.getSetMealId()).ifPresent(setMealId -> predicates.add(criteriaBuilder.equal(root.get("setMealId").as(String.class), setMealId)));
            Optional.ofNullable(customerSetMeal.getCreateTime()).ifPresent(createTime -> predicates.add(criteriaBuilder.equal(root.get("createTime").as(Date.class), createTime)));
            Optional.ofNullable(customerSetMeal.getCreateUserId()).ifPresent(createUserId -> predicates.add(criteriaBuilder.equal(root.get("createUserId").as(String.class), createUserId)));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}