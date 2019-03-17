package com.zq.vm.repository.specification;

import  com.zq.vm.entity.Customer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * 会员信息条件查询
 */
public class CustomerSpecification {

    /**
     * 默认条件查询
     * @param customer
     * @return
     */
    public static Specification<Customer> specification(final Customer customer){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(criteriaBuilder.equal(root.get("name").as(String.class), customer.getName()));
			predicates.add(criteriaBuilder.equal(root.get("sex").as(Integer.class), customer.getSex()));
			predicates.add(criteriaBuilder.equal(root.get("phoneNumber").as(String.class), customer.getPhoneNumber()));
			predicates.add(criteriaBuilder.equal(root.get("age").as(Integer.class), customer.getAge()));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}