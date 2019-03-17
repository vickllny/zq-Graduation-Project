package com.zq.vm.repository.specification;

import  com.zq.vm.entity.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;

/**
 * 用户条件查询
 */
public class UserSpecification {

    /**
     * 默认条件查询
     * @param user
     * @return
     */
    public static Specification<User> specification(final User user){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
            Optional.ofNullable(user.getUserNane()).ifPresent(userNane -> predicates.add(criteriaBuilder.equal(root.get("userNane").as(String.class), userNane)));
            Optional.ofNullable(user.getPassword()).ifPresent(password -> predicates.add(criteriaBuilder.equal(root.get("password").as(String.class), password)));
            Optional.ofNullable(user.getPhoneNumber()).ifPresent(phoneNumber -> predicates.add(criteriaBuilder.equal(root.get("phoneNumber").as(String.class), phoneNumber)));
            Optional.ofNullable(user.getWorkNumber()).ifPresent(workNumber -> predicates.add(criteriaBuilder.equal(root.get("workNumber").as(String.class), workNumber)));
            Optional.ofNullable(user.getCreateTime()).ifPresent(createTime -> predicates.add(criteriaBuilder.equal(root.get("createTime").as(Date.class), createTime)));
            Optional.ofNullable(user.getCreateUserId()).ifPresent(createUserId -> predicates.add(criteriaBuilder.equal(root.get("createUserId").as(String.class), createUserId)));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}