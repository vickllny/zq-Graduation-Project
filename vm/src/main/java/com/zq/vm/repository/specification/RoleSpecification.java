package com.zq.vm.repository.specification;

import  com.zq.vm.entity.Role;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Optional;

/**
 * 角色条件查询
 */
public class RoleSpecification {

    /**
     * 默认条件查询
     * @param role
     * @return
     */
    public static Specification<Role> specification(final Role role){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
            Optional.ofNullable(role.getName()).ifPresent(name -> predicates.add(criteriaBuilder.equal(root.get("name").as(String.class), name)));
            Optional.ofNullable(role.getStatus()).ifPresent(status -> predicates.add(criteriaBuilder.equal(root.get("status").as(String.class), status)));
            Optional.ofNullable(role.getCreateTime()).ifPresent(createTime -> predicates.add(criteriaBuilder.equal(root.get("createTime").as(Date.class), createTime)));
            Optional.ofNullable(role.getRoleCode()).ifPresent(roleCode -> predicates.add(criteriaBuilder.equal(root.get("roleCode").as(String.class), roleCode)));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}