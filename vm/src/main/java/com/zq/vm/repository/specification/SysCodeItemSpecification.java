package com.zq.vm.repository.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import  com.zq.vm.entity.SysCodeItem;

/**
 * 系统编码值条件查询
 */
public class SysCodeItemSpecification {

    /**
     * 默认条件查询
     * @param sysCodeItem
     * @return
     */
    public static Specification<SysCodeItem> specification(final SysCodeItem sysCodeItem){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
            Optional.ofNullable(sysCodeItem.getName()).ifPresent(name -> predicates.add(criteriaBuilder.equal(root.get("name").as(String.class), name)));
            Optional.ofNullable(sysCodeItem.getCode()).ifPresent(code -> predicates.add(criteriaBuilder.equal(root.get("code").as(String.class), code)));
            Optional.ofNullable(sysCodeItem.getSort()).ifPresent(sort -> predicates.add(criteriaBuilder.equal(root.get("sort").as(String.class), sort)));
            Optional.ofNullable(sysCodeItem.getSysCodeId()).ifPresent(sysCodeId -> predicates.add(criteriaBuilder.equal(root.get("sysCodeId").as(String.class), sysCodeId)));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}