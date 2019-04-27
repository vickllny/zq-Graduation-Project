package com.zq.vm.repository.specification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import  com.zq.vm.entity.ProductStock;
import com.zq.vm.entity.vo.ProductStockVo;

/**
 * 商品库存条件查询
 */
public class ProductStockSpecification {

    /**
     * 默认条件查询
     * @param productStock
     * @return
     */
    public static Specification<ProductStock> specification(final ProductStock productStock){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
            Optional.ofNullable(productStock.getProductId()).ifPresent(productId -> predicates.add(criteriaBuilder.equal(root.get("productId").as(String.class), productId)));
            Optional.ofNullable(productStock.getProductStockNumber()).ifPresent(productStockNumber -> predicates.add(criteriaBuilder.equal(root.get("productStockNumber").as(String.class), productStockNumber)));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}

	public static Specification<ProductStock> findstatisticsSpecification(ProductStockVo vo) {
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
            Optional.ofNullable(vo.getType()).ifPresent(type -> predicates.add(criteriaBuilder.equal(root.get("type").as(Integer.class), type)));
            Optional.ofNullable(vo.getStartTime()).ifPresent(startTime -> predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createTime").as(Date.class), startTime)));
            Optional.ofNullable(vo.getEndTime()).ifPresent(endTime -> predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("createTime").as(Date.class), endTime)));
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}