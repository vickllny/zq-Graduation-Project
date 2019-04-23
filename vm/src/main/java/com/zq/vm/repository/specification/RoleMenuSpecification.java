package com.zq.vm.repository.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import  com.zq.vm.entity.RoleMenu;

/**
 * 角色菜单条件查询
 */
public class RoleMenuSpecification {

    /**
     * 默认条件查询
     * @param roleMenu
     * @return
     */
    public static Specification<RoleMenu> specification(final RoleMenu roleMenu){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
            Optional.ofNullable(roleMenu.getRoleId()).ifPresent(roleId -> predicates.add(criteriaBuilder.equal(root.get("roleId").as(String.class), roleId)));
            Optional.ofNullable(roleMenu.getMenuId()).ifPresent(menuId -> predicates.add(criteriaBuilder.equal(root.get("menuId").as(String.class), menuId)));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}