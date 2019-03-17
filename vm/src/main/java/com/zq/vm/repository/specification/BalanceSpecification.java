package com.zq.vm.repository.specification;

import  com.zq.vm.entity.Balance;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 余额信息条件查询
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
			predicates.add(criteriaBuilder.equal(root.get("customerId").as(String.class), balance.getCustomerId()));
			predicates.add(criteriaBuilder.equal(root.get("balance").as(BigDecimal.class), balance.getBalance()));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}