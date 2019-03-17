package com.zq.vm.repository.specification;

import  com.zq.vm.entity.NumbersRechargeRecord;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 余额信息条件查询
 */
public class NumbersRechargeRecordSpecification {

    /**
     * 默认条件查询
     * @param numbersRechargeRecord
     * @return
     */
    public static Specification<NumbersRechargeRecord> specification(final NumbersRechargeRecord numbersRechargeRecord){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(criteriaBuilder.equal(root.get("customerId").as(String.class), numbersRechargeRecord.getCustomerId()));
			predicates.add(criteriaBuilder.equal(root.get("rechargeNumbers").as(Integer.class), numbersRechargeRecord.getRechargeNumbers()));
			predicates.add(criteriaBuilder.equal(root.get("rechargeTime").as(Date.class), numbersRechargeRecord.getRechargeTime()));
			predicates.add(criteriaBuilder.equal(root.get("serviceId").as(String.class), numbersRechargeRecord.getServiceId()));
			predicates.add(criteriaBuilder.equal(root.get("spendBalance").as(BigDecimal.class), numbersRechargeRecord.getSpendBalance()));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}