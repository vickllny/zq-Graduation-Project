package com.zq.vm.repository.specification;

import  com.zq.vm.entity.NumbersRechargeRecord;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Optional;

/**
 * 服务次数充值记录表条件查询
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
            Optional.ofNullable(numbersRechargeRecord.getCustomerId()).ifPresent(customerId -> predicates.add(criteriaBuilder.equal(root.get("customerId").as(String.class), customerId)));
            Optional.ofNullable(numbersRechargeRecord.getRechargeNumbers()).ifPresent(rechargeNumbers -> predicates.add(criteriaBuilder.equal(root.get("rechargeNumbers").as(String.class), rechargeNumbers)));
            Optional.ofNullable(numbersRechargeRecord.getRechargeTime()).ifPresent(rechargeTime -> predicates.add(criteriaBuilder.equal(root.get("rechargeTime").as(Date.class), rechargeTime)));
            Optional.ofNullable(numbersRechargeRecord.getServiceId()).ifPresent(serviceId -> predicates.add(criteriaBuilder.equal(root.get("serviceId").as(String.class), serviceId)));
            Optional.ofNullable(numbersRechargeRecord.getSpendBalance()).ifPresent(spendBalance -> predicates.add(criteriaBuilder.equal(root.get("spendBalance").as(String.class), spendBalance)));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}