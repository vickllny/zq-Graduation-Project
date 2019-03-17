package com.zq.vm.repository.specification;

import  com.zq.vm.entity.SetMealInformation;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 余额信息条件查询
 */
public class SetMealInformationSpecification {

    /**
     * 默认条件查询
     * @param setMealInformation
     * @return
     */
    public static Specification<SetMealInformation> specification(final SetMealInformation setMealInformation){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(criteriaBuilder.equal(root.get("name").as(String.class), setMealInformation.getName()));
			predicates.add(criteriaBuilder.equal(root.get("mealTimelimit").as(Date.class), setMealInformation.getMealTimelimit()));
			predicates.add(criteriaBuilder.equal(root.get("isUse").as(Integer.class), setMealInformation.getIsUse()));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}