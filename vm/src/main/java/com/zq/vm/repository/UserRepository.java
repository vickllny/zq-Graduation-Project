package com.zq.vm.repository;

import com.zq.vm.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 描述: 用户业务数据访问类
 * Time: 2019-03-17 18:43:21
 * @author: zou.qian
 * @version 1.0
 */
public interface UserRepository extends PagingAndSortingRepository<User,String>, JpaSpecificationExecutor<User> {


}
