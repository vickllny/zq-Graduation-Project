package com.zq.vm.repository.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import  com.zq.vm.entity.Balance;

/**
 * 余额条件查询
 */
public class BalanceSpecification {

    /**
     * 默认条件查询
     * @param balance
     * @return
     */
    public static Specification<Balance> specification(final Balance balance){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
            Optional.ofNullable(balance.getCustomerId()).ifPresent(customerId -> predicates.add(criteriaBuilder.equal(root.get("customerId").as(String.class), customerId)));
            Optional.ofNullable(balance.getBalance()).ifPresent(balance1 -> predicates.add(criteriaBuilder.equal(root.get("balance").as(String.class), balance)));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}