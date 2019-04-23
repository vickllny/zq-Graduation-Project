package com.zq.vm.service;

import com.zq.vm.entity.CustomerSetMealProduction;
import com.zq.vm.entity.vo.CustomerSetMealProductionVo;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 描述: 会员套餐商品关系表业务接口
 * Time: 2019-04-23 22:04:24
 * @author: zou.qian
 * @version 1.0
 */
public interface CustomerSetMealProductionService{

    /**
     * 保存
     * @param customerSetMealProduction
     * @return
     */
	CustomerSetMealProduction save(CustomerSetMealProduction customerSetMealProduction);

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
     * @param customerSetMealProduction
     * @return
     */
    Page<CustomerSetMealProduction> findPageByCriteria(int pageNumber, int pageSize, CustomerSetMealProduction customerSetMealProduction);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	CustomerSetMealProduction findOne(String id);

    /**
     * 查询所有
     * @return
     */
    List<CustomerSetMealProduction> findAll();

    /**
     * //保存会员套餐商品信息
     * @param customerId
     * @param setMealId
     * @param setMealProductId
     */
	void save(String customerId, String setMealId, String setMealProductId);

	/**
	 * 获取已购套餐下的商品
	 * @param customerSetMealId
	 * @return
	 */
	List<CustomerSetMealProductionVo> findVoByCustomerSetMealId(String customerSetMealId);
}
