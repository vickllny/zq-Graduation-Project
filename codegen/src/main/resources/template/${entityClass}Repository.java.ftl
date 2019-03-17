package ${package}.repository;

import ${package}.entity.${entityClass};
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 描述: ${logicName}业务数据访问类
 * Time: ${time}
 * @author: ${author}
 * @version 1.0
 */
public interface ${entityClass}Repository extends PagingAndSortingRepository<${entityClass},String>, JpaSpecificationExecutor<${entityClass}> {


}
