package com.zq.vm.service;

import com.zq.vm.entity.Customer;
import com.zq.vm.entity.vo.CustomerBusinessVo;

import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

/**
 * 描述: 会员业务接口
 * Time: 2019-03-25 14:23:23
 * @author: zou.qian
 * @version 1.0
 */
public interface CustomerService{

    /**
     * 保存
     * @param customer
     * @return
     */
	Customer save(Customer customer);

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
     * @param customer
     * @return
     */
    Page<Customer> findPageByCriteria(int pageNumber, int pageSize, Customer customer);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	Customer findOne(String id);

    /**
     * 查询所有
     * @return
     */
    List<Customer> findAll();

    /**
     * 查询指定状态的会员
     * @param flag
     * @return
     */
	List<Customer> findCustomersByStatus(int flag);

	/**
	 * 跟选择的时间查询
	 * @param pageNumber
	 * @param pageSize
	 * @param createTime
	 * @return
	 */
	Page<Customer> findPageByCreateTime(Integer pageNumber, Integer pageSize, String createTime);

	/**
	 * 会员业务单据统计
	 * @param pageNumber
	 * @param pageSize
	 * @param customerId
	 * @param type
	 * @return
	 */
	Page<Object[]> findPageByCustomerIdAndType(Integer pageNumber, Integer pageSize, String customerId,
			String type);

	/**
	 * 消费排行
	 * @param pageNumber
	 * @param pageSize
	 * @param name
	 * @return
	 */
	Page<Object[]> findConsumeRankPage(Integer pageNumber, Integer pageSize, String name);

	/**
	 * 查询会员生日分页数据
	 * @param pageNumber
	 * @param pageSize
	 * @param nowDate
	 * @param name
	 * @return
	 */
	Page<Customer> findBirthRemindPage(Integer pageNumber, Integer pageSize, Date nowDate, String name);
}
