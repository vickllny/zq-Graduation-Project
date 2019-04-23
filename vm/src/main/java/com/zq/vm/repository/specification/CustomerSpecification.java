package com.zq.vm.repository.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import  com.zq.vm.entity.Customer;

/**
 * 会员条件查询
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
            Optional.ofNullable(customer.getName()).ifPresent(name -> predicates.add(criteriaBuilder.equal(root.get("name").as(String.class), name)));
            Optional.ofNullable(customer.getSex()).ifPresent(sex -> predicates.add(criteriaBuilder.equal(root.get("sex").as(String.class), sex)));
            Optional.ofNullable(customer.getPhoneNumber()).ifPresent(phoneNumber -> predicates.add(criteriaBuilder.equal(root.get("phoneNumber").as(String.class), phoneNumber)));
            Optional.ofNullable(customer.getAge()).ifPresent(age -> predicates.add(criteriaBuilder.equal(root.get("age").as(String.class), age)));
            Optional.ofNullable(customer.getDel()).ifPresent(del -> predicates.add(criteriaBuilder.equal(root.get("del").as(String.class), del)));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}

    /**
     * 查询指定状态的会员
     * @param flag
     * @return
     */
	public static Specification<Customer> statusSpecification(int flag) {
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("del").as(String.class), flag));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}