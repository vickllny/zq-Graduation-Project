package ${package}.service.impl;

import ${package}.repository.${entityClass}Repository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import ${package}.entity.${entityClass};
import ${package}.service.${entityClass}Service;
import ${package}.repository.specification.${entityClass}Specification;

import java.util.List;

/**
 * 描述:${logicName}业务实现 
 * Time: ${time}
 * @author: ${author}
 * @version 1.0
 */
@Service
public class ${entityClass}ServiceImpl extends BaseServiceImpl<${entityClass}, String> implements ${entityClass}Service{

	@Autowired
	private ${entityClass}Repository ${simpleName}Repository;
	
    @Override
    public void delete(String id) {
        ${simpleName}Repository.deleteById(id);
    }

    @Override
    public ${entityClass} findOne(String id) {
        return ${simpleName}Repository.findById(id).orElse(new ${entityClass}());
    }

    @Override
    public ${entityClass} save(${entityClass} ${simpleName}) {
        return ${simpleName}Repository.save(${simpleName});
    }

    @Override
    public Page<${entityClass}> findPageByCriteria(int pageNumber, int pageSize, final ${entityClass} ${simpleName}) {
    	return ${simpleName}Repository.findAll(${entityClass}Specification.specification(${simpleName}), buildPageRequest(pageNumber, pageSize));
    }

    @Override
    public List<${entityClass}> findAll() {
        return super.findList(${simpleName}Repository.findAll());
    }
}
