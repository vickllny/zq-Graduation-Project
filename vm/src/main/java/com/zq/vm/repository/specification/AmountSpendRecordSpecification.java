package com.zq.vm.repository.specification;

import  com.zq.vm.entity.AmountSpendRecord;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 余额信息条件查询
 */
public class AmountSpendRecordSpecification {

    /**
     * 默认条件查询
     * @param amountSpendRecord
     * @return
     */
    public static Specification<AmountSpendRecord> specification(final AmountSpendRecord amountSpendRecord){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(criteriaBuilder.equal(root.get("customerId").as(String.class), amountSpendRecord.getCustomerId()));
			predicates.add(criteriaBuilder.equal(root.get("productId").as(String.class), amountSpendRecord.getProductId()));
			predicates.add(criteriaBuilder.equal(root.get("amountSpend").as(BigDecimal.class), amountSpendRecord.getAmountSpend()));
			predicates.add(criteriaBuilder.equal(root.get("spendTime").as(Date.class), amountSpendRecord.getSpendTime()));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}