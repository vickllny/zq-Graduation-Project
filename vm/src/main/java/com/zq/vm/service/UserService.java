package com.zq.vm.service;

import com.zq.vm.entity.User;

import java.util.List;

import org.springframework.data.domain.Page;

/**
 * 描述: 用户业务接口
 * Time: 2019-03-17 18:43:21
 * @author: zou.qian
 * @version 1.0
 */
public interface UserService{

    /**
     * 保存
     * @param user
     * @return
     */
	User save(User user);

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
     * @param user
     * @return
     */
    Page<User> findPageByCriteria(int pageNumber, int pageSize, User user);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	User findOne(String id);

    /**
     * 查询所有
     * @return
     */
    List<User> findAll();

    /**
     * 根据userName查询
     * @param userName
     * @return
     */
    User findByUserName(String userName);
}
