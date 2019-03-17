package com.zq.vm.service;

import com.zq.vm.entity.Menu;

import com.zq.vm.entity.ZTree;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 描述: 菜单业务接口
 * Time: 2019-03-03 21:20:03
 * @author: zou.qian
 * @version 1.0
 */
public interface MenuService{

    /**
     * 保存
     * @param menu
     * @return
     */
	Menu save(Menu menu);

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
     * @param menu
     * @return
     */
    Page<Menu> findPageByCriteria(int pageNumber, int pageSize, Menu menu);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	Menu findOne(String id);

    /**
     * 树数据
     * @return
     */
    List<ZTree> treeData();

    /**
     * 查询所有
     * @return
     */
    List<Menu> findAll();

    /**
     * 根据pid查询菜单
     * @param pid
     * @return
     */
	List<Menu> findByPid(String pid);
}
