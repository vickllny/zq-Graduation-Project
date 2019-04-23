package com.zq.vm.repository.specification;

import  com.zq.vm.entity.SysCode;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Optional;

/**
 * 系统code条件查询
 */
public class SysCodeSpecification {

    /**
     * 默认条件查询
     * @param sysCode
     * @return
     */
    public static Specification<SysCode> specification(final SysCode sysCode){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
            Optional.ofNullable(sysCode.getName()).ifPresent(name -> predicates.add(criteriaBuilder.equal(root.get("name").as(String.class), name)));
            Optional.ofNullable(sysCode.getDescription()).ifPresent(description -> predicates.add(criteriaBuilder.equal(root.get("description").as(String.class), description)));
            Optional.ofNullable(sysCode.getCode()).ifPresent(code -> predicates.add(criteriaBuilder.equal(root.get("code").as(String.class), code)));
            Optional.ofNullable(sysCode.getCreateTime()).ifPresent(createTime -> predicates.add(criteriaBuilder.equal(root.get("createTime").as(Date.class), createTime)));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}