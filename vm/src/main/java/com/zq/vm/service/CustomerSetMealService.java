package com.zq.vm.service;

import com.zq.vm.entity.CustomerSetMeal;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 描述: 会员套餐关系表业务接口
 * Time: 2019-04-22 23:40:19
 * @author: zou.qian
 * @version 1.0
 */
public interface CustomerSetMealService{

    /**
     * 保存
     * @param customerSetMeal
     * @return
     */
	CustomerSetMeal save(CustomerSetMeal customerSetMeal);

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
     * @param customerSetMeal
     * @return
     */
    Page<CustomerSetMeal> findPageByCriteria(int pageNumber, int pageSize, CustomerSetMeal customerSetMeal);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	CustomerSetMeal findOne(String id);

    /**
     * 查询所有
     * @return
     */
    List<CustomerSetMeal> findAll();

    /**
     * 保存并且扣款
     * @param customerSetMeal
     */
	void saveAndDeduction(CustomerSetMeal customerSetMeal);
}
