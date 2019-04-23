package com.zq.vm.service.impl;

import com.zq.vm.entity.ZTree;
import com.zq.vm.repository.MenuRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.Menu;
import com.zq.vm.entity.User;
import com.zq.vm.service.MenuService;
import com.zq.vm.repository.specification.MenuSpecification;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 描述:菜单业务实现 
 * Time: 2019-03-03 21:20:03
 * @author: zou.qian
 * @version 1.0
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu, String> implements MenuService{

	@Autowired
	private MenuRepository menuRepository;
	
    @Override
    public void delete(String id) {
        menuRepository.deleteById(id);
    }

    @Override
    public List<Menu> findAll() {
        return super.findList(menuRepository.findAll());
    }

    @Override
    public Menu findOne(String id) {
        return menuRepository.findById(id).orElse(new Menu());
    }

    @Override
    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Page<Menu> findPageByCriteria(int pageNumber, int pageSize, final Menu menu) {
    	return menuRepository.findAll(MenuSpecification.specification(menu), buildPageRequest(pageNumber, pageSize));
    }

    @Override
    public List<ZTree> treeData() {
        Iterator<Menu> iterator = menuRepository.findAll().iterator();
        List<ZTree> list = new ArrayList<>();
        while (iterator != null && iterator.hasNext()){
            Menu menu = iterator.next();
            list.add(new ZTree(menu.getId(), menu.getName(), menu.getPid()));
        }
        return list;
    }

	@Override
	public List<Menu> findByPid(String id) {
		return menuRepository.findByPid(id);
	}

	@Override
	public List<Menu> findMenuByUserId(String userId) {
		if(userId.equals(User.SUPER_USER_ID)) {
			return findAll();
		}
		return menuRepository.findMenuByUserId(userId);
	}
}
