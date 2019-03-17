package com.zq.vm.repository.specification;

import  com.zq.vm.entity.ServiceInformation;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 余额信息条件查询
 */
public class ServiceInformationSpecification {

    /**
     * 默认条件查询
     * @param serviceInformation
     * @return
     */
    public static Specification<ServiceInformation> specification(final ServiceInformation serviceInformation){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(criteriaBuilder.equal(root.get("name").as(String.class), serviceInformation.getName()));
			predicates.add(criteriaBuilder.equal(root.get("description").as(String.class), serviceInformation.getDescription()));
			predicates.add(criteriaBuilder.equal(root.get("createTime").as(Date.class), serviceInformation.getCreateTime()));
			predicates.add(criteriaBuilder.equal(root.get("serviceClassId").as(String.class), serviceInformation.getServiceClassId()));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}