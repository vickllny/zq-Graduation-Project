package com.zq.vm.repository.specification;

import  com.zq.vm.entity.SetMealInformationProduct;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * 余额信息条件查询
 */
public class SetMealInformationProductSpecification {

    /**
     * 默认条件查询
     * @param setMealInformationProduct
     * @return
     */
    public static Specification<SetMealInformationProduct> specification(final SetMealInformationProduct setMealInformationProduct){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(criteriaBuilder.equal(root.get("setMealInformationId").as(String.class), setMealInformationProduct.getSetMealInformationId()));
			predicates.add(criteriaBuilder.equal(root.get("productId").as(String.class), setMealInformationProduct.getProductId()));
			predicates.add(criteriaBuilder.equal(root.get("count").as(Integer.class), setMealInformationProduct.getCount()));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}