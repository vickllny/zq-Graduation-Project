package ${package}.repository.specification;

import  ${package}.entity.${entityClass};
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Optional;

/**
 * ${logicName}条件查询
 */
public class ${entityClass}Specification {

    /**
     * 默认条件查询
     * @param ${simpleName}
     * @return
     */
    public static Specification<${entityClass}> specification(final ${entityClass} ${simpleName}){
    	return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
				<#list columns as list>
					<#if !list.pk>
                        <#if list.javaType == 'Date'>
            Optional.ofNullable(${simpleName}.get${list.capitalizeName}()).ifPresent(${list.fieldName} -> predicates.add(criteriaBuilder.equal(root.get("${list.fieldName}").as(Date.class), ${list.fieldName})));
                        <#else>
            Optional.ofNullable(${simpleName}.get${list.capitalizeName}()).ifPresent(${list.fieldName} -> predicates.add(criteriaBuilder.equal(root.get("${list.fieldName}").as(String.class), ${list.fieldName})));
                        </#if>
					</#if>
				</#list>
			return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
        };
	}
}