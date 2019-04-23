package com.zq.vm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.zq.vm.entity.Role;
import com.zq.vm.entity.ZTree;
import com.zq.vm.repository.RoleRepository;
import com.zq.vm.repository.specification.RoleSpecification;
import com.zq.vm.service.RoleService;

/**
 * 描述:角色业务实现 
 * Time: 2019-03-22 22:05:20
 * @author: zou.qian
 * @version 1.0
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, String> implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
    @Override
    public void delete(String id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role findOne(String id) {
        return roleRepository.findById(id).orElse(new Role());
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Page<Role> findPageByCriteria(int pageNumber, int pageSize, final Role role) {
    	return roleRepository.findAll(RoleSpecification.specification(role), buildPageRequest(pageNumber, pageSize));
    }

    @Override
    public List<Role> findAll() {
        return super.findList(roleRepository.findAll());
    }

	@Override
	public List<ZTree> permission(String roleId) {
		List<Map<String, Object>> list = roleRepository.permission(roleId);
		List<ZTree> result = new ArrayList<>(list.size());
		list.parallelStream().forEach(map -> {
			String id = String.valueOf(map.get("ID"));
			String name = String.valueOf(map.get("NAME"));
			String pid = String.valueOf(map.get("PID"));
			boolean flag = String.valueOf(map.get("FLAG")).equals("1");
			result.add(new ZTree(id, name, pid, flag));
		});
		return result;
	}
}
