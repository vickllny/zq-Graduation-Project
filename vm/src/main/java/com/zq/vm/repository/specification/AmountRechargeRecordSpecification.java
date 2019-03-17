package com.zq.vm.repository.specification;

import  com.zq.vm.entity.AmountRechargeRecord;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 余额信息条件查询
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
			predicates.add(criteriaBuilder.equal(root.get("customerId").as(String.class), amountRechargeRecord.getCustomerId()));
			predicates.add(criteriaBuilder.equal(root.get("rechargeAmount").as(BigDecimal.class), amountRechargeRecord.getRechargeAmount()));
			predicates.add(criteriaBuilder.equal(root.get("rechargeTime").as(Date.class), amountRechargeRecord.getRechargeTime()));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}