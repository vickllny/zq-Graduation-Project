package com.zq.vm.repository.specification;

import  com.zq.vm.entity.NumbersSpendRecord;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 余额信息条件查询
 */
public class NumbersSpendRecordSpecification {

    /**
     * 默认条件查询
     * @param numbersSpendRecord
     * @return
     */
    public static Specification<NumbersSpendRecord> specification(final NumbersSpendRecord numbersSpendRecord){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(criteriaBuilder.equal(root.get("customerId").as(String.class), numbersSpendRecord.getCustomerId()));
			predicates.add(criteriaBuilder.equal(root.get("spendNumbers").as(Integer.class), numbersSpendRecord.getSpendNumbers()));
			predicates.add(criteriaBuilder.equal(root.get("spendTime").as(Date.class), numbersSpendRecord.getSpendTime()));
			predicates.add(criteriaBuilder.equal(root.get("serviceId").as(String.class), numbersSpendRecord.getServiceId()));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}