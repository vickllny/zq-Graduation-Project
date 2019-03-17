package ${package}.service;

import ${package}.entity.${entityClass};

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 描述: ${logicName}业务接口
 * Time: ${time}
 * @author: ${author}
 * @version 1.0
 */
public interface ${entityClass}Service{

    /**
     * 保存
     * @param ${simpleName}
     * @return
     */
	${entityClass} save(${entityClass} ${simpleName});

    /**
     * 删除
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param ${simpleName}
     * @return
     */
    Page<${entityClass}> findPageByCriteria(int pageNumber, int pageSize, ${entityClass} ${simpleName});

    /**
    * 根据id查询
    * @param id
    * @return
    */
	${entityClass} findOne(String id);

    /**
     * 查询所有
     * @return
     */
    List<${entityClass}> findAll();
}
