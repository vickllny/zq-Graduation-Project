package com.zq.vm.repository.specification;

import  com.zq.vm.entity.CustomerNumbers;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * 余额信息条件查询
 */
public class CustomerNumbersSpecification {

    /**
     * 默认条件查询
     * @param customerNumbers
     * @return
     */
    public static Specification<CustomerNumbers> specification(final CustomerNumbers customerNumbers){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(criteriaBuilder.equal(root.get("customerId").as(String.class), customerNumbers.getCustomerId()));
			predicates.add(criteriaBuilder.equal(root.get("numbers").as(Integer.class), customerNumbers.getNumbers()));
			predicates.add(criteriaBuilder.equal(root.get("serviceId").as(String.class), customerNumbers.getServiceId()));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}