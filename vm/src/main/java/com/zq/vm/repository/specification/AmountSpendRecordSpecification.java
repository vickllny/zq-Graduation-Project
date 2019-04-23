package com.zq.vm.repository.specification;

import  com.zq.vm.entity.AmountSpendRecord;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Optional;

/**
 * 余额充值记录条件查询
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
            Optional.ofNullable(amountSpendRecord.getCustomerId()).ifPresent(customerId -> predicates.add(criteriaBuilder.equal(root.get("customerId").as(String.class), customerId)));
            Optional.ofNullable(amountSpendRecord.getProductId()).ifPresent(productId -> predicates.add(criteriaBuilder.equal(root.get("productId").as(String.class), productId)));
            Optional.ofNullable(amountSpendRecord.getAmountSpend()).ifPresent(amountSpend -> predicates.add(criteriaBuilder.equal(root.get("amountSpend").as(String.class), amountSpend)));
            Optional.ofNullable(amountSpendRecord.getSpendTime()).ifPresent(spendTime -> predicates.add(criteriaBuilder.equal(root.get("spendTime").as(Date.class), spendTime)));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}