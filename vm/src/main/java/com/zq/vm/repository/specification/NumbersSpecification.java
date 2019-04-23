package com.zq.vm.repository.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import  com.zq.vm.entity.Numbers;

/**
 * 会员次数记录表条件查询
 */
public class NumbersSpecification {

    /**
     * 默认条件查询
     * @param numbers
     * @return
     */
    public static Specification<Numbers> specification(final Numbers numbers){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
            Optional.ofNullable(numbers.getCustomerId()).ifPresent(customerId -> predicates.add(criteriaBuilder.equal(root.get("customerId").as(String.class), customerId)));
            Optional.ofNullable(numbers.getServiceId()).ifPresent(serviceId -> predicates.add(criteriaBuilder.equal(root.get("serviceId").as(String.class), serviceId)));
            Optional.ofNullable(numbers.getNumbers()).ifPresent(number -> predicates.add(criteriaBuilder.equal(root.get("numbers").as(String.class), number)));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}