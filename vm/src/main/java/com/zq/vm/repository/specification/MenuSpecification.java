package com.zq.vm.repository.specification;

import  com.zq.vm.entity.Menu;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 菜单条件查询
 */
public class MenuSpecification {

    /**
     * 默认条件查询
     * @param menu
     * @return
     */
    public static Specification<Menu> specification(final Menu menu){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			Optional.ofNullable(menu.getName()).ifPresent(name -> predicates.add(criteriaBuilder.equal(root.get("name").as(String.class), name)));
			Optional.ofNullable(menu.getPid()).ifPresent(pid -> predicates.add(criteriaBuilder.equal(root.get("pid").as(String.class), pid)));
			Optional.ofNullable(menu.getUrl()).ifPresent(url -> predicates.add(criteriaBuilder.equal(root.get("url").as(String.class), url)));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}