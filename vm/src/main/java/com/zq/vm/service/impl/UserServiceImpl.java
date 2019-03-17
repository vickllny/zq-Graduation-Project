package com.zq.vm.service.impl;

import com.zq.vm.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.User;
import com.zq.vm.service.UserService;
import com.zq.vm.repository.specification.UserSpecification;

/**
 * 描述:用户业务实现 
 * Time: 2019-03-17 18:43:21
 * @author: zou.qian
 * @version 1.0
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService{

	@Autowired
	private UserRepository userRepository;
	
    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findOne(String id) {
        return userRepository.findById(id).orElse(new User());
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Page<User> findPageByCriteria(int pageNumber, int pageSize, final User user) {
    	return userRepository.findAll(UserSpecification.specification(user), buildPageRequest(pageNumber, pageSize));
    }

    @Override
    public List<User> findAll() {
        return super.findList(userRepository.findAll());
    }
}
