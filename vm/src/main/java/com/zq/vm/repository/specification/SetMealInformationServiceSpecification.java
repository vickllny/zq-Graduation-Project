package com.zq.vm.repository.specification;

import  com.zq.vm.entity.SetMealInformationService;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * 余额信息条件查询
 */
public class SetMealInformationServiceSpecification {

    /**
     * 默认条件查询
     * @param setMealInformationService
     * @return
     */
    public static Specification<SetMealInformationService> specification(final SetMealInformationService setMealInformationService){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(criteriaBuilder.equal(root.get("setMealInformationId").as(String.class), setMealInformationService.getSetMealInformationId()));
			predicates.add(criteriaBuilder.equal(root.get("serviceId").as(String.class), setMealInformationService.getServiceId()));
			predicates.add(criteriaBuilder.equal(root.get("count").as(Integer.class), setMealInformationService.getCount()));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}