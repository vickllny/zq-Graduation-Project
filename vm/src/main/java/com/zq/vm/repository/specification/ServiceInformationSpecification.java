package com.zq.vm.repository.specification;

import  com.zq.vm.entity.ServiceInformation;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Optional;

/**
 * 服务信息表(商品)条件查询
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
            Optional.ofNullable(serviceInformation.getName()).ifPresent(name -> predicates.add(criteriaBuilder.equal(root.get("name").as(String.class), name)));
            Optional.ofNullable(serviceInformation.getDescription()).ifPresent(description -> predicates.add(criteriaBuilder.equal(root.get("description").as(String.class), description)));
            Optional.ofNullable(serviceInformation.getCreateTime()).ifPresent(createTime -> predicates.add(criteriaBuilder.equal(root.get("createTime").as(Date.class), createTime)));
            Optional.ofNullable(serviceInformation.getType()).ifPresent(type -> predicates.add(criteriaBuilder.equal(root.get("type").as(String.class), type)));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}