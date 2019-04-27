package com.zq.vm.repository;

import com.zq.vm.entity.Customer;
import com.zq.vm.entity.vo.CustomerBusinessVo;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;import org.springframework.transaction.annotation.Transactional;

/**
 * 描述: 会员业务数据访问类
 * Time: 2019-03-25 14:23:23
 * @author: zou.qian
 * @version 1.0
 */
public interface CustomerRepository extends PagingAndSortingRepository<Customer,String>, JpaSpecificationExecutor<Customer> {

	/**
	 * 根据开始时间和结束时间查询
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@Query(value = "select * from customer where 1=1 and create_time between :startTime and :endTime",
			countQuery = "select count(1) from customer where 1=1 and create_time between :startTime and :endTime", nativeQuery = true)
	Page<Customer> findPageByCreateTimeBetween(@Param(value = "startTime")String startTime,@Param(value = "endTime") String endTime, Pageable pageable);

	/**
	 * 业务统计查询
	 * @param customerId
	 * @param type
	 * @param buildPageRequest
	 * @return
	 */
	@Query(value = "select c.id,c.name,temp.* from customer c INNER JOIN\n" + 
			"(select cs.customer_id,cs.create_time,sm.id as product_id,sm.name as product_name,'setMeal' as type,sm.price as amount from customer_set_meal cs INNER JOIN set_meal_information sm on sm.id = cs.set_meal_id\n" + 
			"union\n" + 
			"select sr.customer_id,sr.spend_time as create_time,sr.product_id,pi.name as product_name,'product' as type,sr.amount_spend as amount from amount_spend_record sr INNER JOIN product_information pi on pi.id = sr.product_id where sr.type = 1\n" + 
			"union\n" + 
			"select ns.customer_id,ns.spend_time as create_time,ns.service_id as product_id,si.name as product_name,'service' as type,si.unit_price as amount from numbers_spend_record ns INNER JOIN service_information si on si.id = ns.service_id\n" + 
			") temp on temp.customer_id = c.id where c.id like :customerId and temp.type like :type ORDER BY temp.create_time desc",
			countQuery = "select count(1) from customer c INNER JOIN\n" + 
					"(select cs.customer_id,cs.create_time,sm.id as product_id,sm.name as product_name,'setMeal' as type,sm.price as amount from customer_set_meal cs INNER JOIN set_meal_information sm on sm.id = cs.set_meal_id\n" + 
					"union\n" + 
					"select sr.customer_id,sr.spend_time as create_time,sr.product_id,pi.name as product_name,'product' as type,sr.amount_spend as amount from amount_spend_record sr INNER JOIN product_information pi on pi.id = sr.product_id where sr.type = 1\n" + 
					"union\n" + 
					"select ns.customer_id,ns.spend_time as create_time,ns.service_id as product_id,si.name as product_name,'service' as type,si.unit_price as amount from numbers_spend_record ns INNER JOIN service_information si on si.id = ns.service_id\n" + 
					") temp on temp.customer_id = c.id where c.id like :customerId and temp.type like :type ORDER BY temp.create_time desc",nativeQuery = true)
	Page<Object[]> findPageByCustomerIdAndType(@Param(value = "customerId")String customerId, @Param(value = "type")String type, Pageable pageable);

	/**
	 * 会员消费排行
	 * @param name
	 * @param pageable
	 * @return
	 */
	@Query(value = "select c.id,c.name,temp.count from customer c LEFT JOIN \n" + 
			"(select customer_id,sum(recharge_amount) as count from amount_recharge_record GROUP BY customer_id) temp  on temp.customer_id = c.id \n" + 
			"where 1=1 and c.name like :name ORDER BY temp.count desc",
			countQuery = "select count(1) from customer c LEFT JOIN \n" + 
					"(select customer_id,sum(recharge_amount) as count from amount_recharge_record GROUP BY customer_id) temp  on temp.customer_id = c.id \n" + 
					"where 1=1 and c.name like :name ORDER BY temp.count desc", nativeQuery = true)
	Page<Object[]> findConsumeRankPage(@Param(value = "name")String name, Pageable pageable);

	/**
	 * 会员生日提醒
	 * @param nowDate
	 * @param name
	 * @param buildPageRequest
	 * @return
	 */
	@Query(value = "select * from customer where date_format(birth,'%m-%d') = date_format(:nowDate,'%m-%d') and name like :name",
			countQuery = "select count(1) from customer where date_format(birth,'%m-%d') = date_format(:nowDate,'%m-%d') and name like :name",
			nativeQuery = true)
	Page<Customer> findBirthRemindPage(@Param(value = "nowDate") Date nowDate,@Param(value = "name") String name, Pageable pageable);

}
