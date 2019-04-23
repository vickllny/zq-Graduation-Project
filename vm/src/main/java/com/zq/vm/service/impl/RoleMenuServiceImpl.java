package com.zq.vm.service.impl;

import com.zq.vm.repository.RoleMenuRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.RoleMenu;
import com.zq.vm.service.RoleMenuService;
import com.zq.vm.repository.specification.RoleMenuSpecification;

import java.util.List;

/**
 * 描述:角色菜单业务实现 
 * Time: 2019-04-10 20:54:16
 * @author: zou.qian
 * @version 1.0
 */
@Transactional
@Service
public class RoleMenuServiceImpl extends BaseServiceImpl<RoleMenu, String> implements RoleMenuService{

	@Autowired
	private RoleMenuRepository roleMenuRepository;
	
    @Override
    public void delete(String id) {
        roleMenuRepository.deleteById(id);
    }

    @Override
    public RoleMenu findOne(String id) {
        return roleMenuRepository.findById(id).orElse(new RoleMenu());
    }

    @Override
    public RoleMenu save(RoleMenu roleMenu) {
        return roleMenuRepository.save(roleMenu);
    }

    @Override
    public Page<RoleMenu> findPageByCriteria(int pageNumber, int pageSize, final RoleMenu roleMenu) {
    	return roleMenuRepository.findAll(RoleMenuSpecification.specification(roleMenu), buildPageRequest(pageNumber, pageSize));
    }

    @Override
    public List<RoleMenu> findAll() {
        return super.findList(roleMenuRepository.findAll());
    }

	@Override
	public void save(String roleId, String[] menuIds) {
		if(menuIds.length == 0) {
			deleteByRoleId(roleId);
			return;
		}
		//先删除之前的数据再保存
		deleteByRoleId(roleId);
		for (String menuId : menuIds) {
			save(new RoleMenu(roleId, menuId));
		}
	}

	@Override
	public void deleteByRoleId(String roleId) {
		roleMenuRepository.deleteByRoleId(roleId);
	}
}
