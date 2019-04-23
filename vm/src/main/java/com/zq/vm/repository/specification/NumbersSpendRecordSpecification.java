package com.zq.vm.repository.specification;

import  com.zq.vm.entity.NumbersSpendRecord;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Optional;

/**
 * 服务次数消费记录表条件查询
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
            Optional.ofNullable(numbersSpendRecord.getCustomerId()).ifPresent(customerId -> predicates.add(criteriaBuilder.equal(root.get("customerId").as(String.class), customerId)));
            Optional.ofNullable(numbersSpendRecord.getSpendNumbers()).ifPresent(spendNumbers -> predicates.add(criteriaBuilder.equal(root.get("spendNumbers").as(String.class), spendNumbers)));
            Optional.ofNullable(numbersSpendRecord.getSpendTime()).ifPresent(spendTime -> predicates.add(criteriaBuilder.equal(root.get("spendTime").as(Date.class), spendTime)));
            Optional.ofNullable(numbersSpendRecord.getServiceId()).ifPresent(serviceId -> predicates.add(criteriaBuilder.equal(root.get("serviceId").as(String.class), serviceId)));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}