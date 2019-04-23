package com.zq.vm.repository.specification;

import  com.zq.vm.entity.AmountRechargeRecord;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Optional;

/**
 * 余额充值记录条件查询
 */
public class AmountRechargeRecordSpecification {

    /**
     * 默认条件查询
     * @param amountRechargeRecord
     * @return
     */
    public static Specification<AmountRechargeRecord> specification(final AmountRechargeRecord amountRechargeRecord){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
            Optional.ofNullable(amountRechargeRecord.getCustomerId()).ifPresent(customerId -> predicates.add(criteriaBuilder.equal(root.get("customerId").as(String.class), customerId)));
            Optional.ofNullable(amountRechargeRecord.getRechargeAmount()).ifPresent(rechargeAmount -> predicates.add(criteriaBuilder.equal(root.get("rechargeAmount").as(String.class), rechargeAmount)));
            Optional.ofNullable(amountRechargeRecord.getRechargeTime()).ifPresent(rechargeTime -> predicates.add(criteriaBuilder.equal(root.get("rechargeTime").as(Date.class), rechargeTime)));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}