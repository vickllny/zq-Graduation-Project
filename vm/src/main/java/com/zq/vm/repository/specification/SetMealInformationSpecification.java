package com.zq.vm.repository.specification;

import  com.zq.vm.entity.SetMealInformation;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Optional;

/**
 * 套餐管理条件查询
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
            Optional.ofNullable(setMealInformation.getName()).ifPresent(name -> predicates.add(criteriaBuilder.equal(root.get("name").as(String.class), name)));
            Optional.ofNullable(setMealInformation.getMealTimelimit()).ifPresent(mealTimelimit -> predicates.add(criteriaBuilder.equal(root.get("mealTimelimit").as(Date.class), mealTimelimit)));
            Optional.ofNullable(setMealInformation.getIsUse()).ifPresent(isUse -> predicates.add(criteriaBuilder.equal(root.get("isUse").as(String.class), isUse)));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}