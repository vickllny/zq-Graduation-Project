package com.zq.vm.entity.vo;

import org.springframework.beans.BeanUtils;

import com.zq.vm.entity.Numbers;

/**
 * 描述: 会员次数记录表vo
 * Time: 2019-04-20 21:55:56
 * @author: zou.qian
 * @version 1.0
 */
public class NumbersVo{
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 会员id
	 */
	private String customerId;
	/**
	 * 服务id
	 */
	private String serviceId;
	/**
	 * 次数
	 */
	private Integer numbers;

	/**
	 * 会员名称
	 */
	private String customerName;
	/**
	 * 服务名称
	 */
	private String serviceName;
	
	public static NumbersVo build(Numbers numbers,String customerName,String serviceName){
		NumbersVo vo = new NumbersVo();
		BeanUtils.copyProperties(numbers, vo);
		vo.customerName = customerName;
		vo.serviceName = serviceName;
		return vo;
	}
	
	/**
	 * 获取主键
	 */
	public String getId(){
		return id;
	}
	/**
	* 设置主键
	* @param id 主键
	*/
	public void setId(String id){
		this.id=id;
	}
	/**
	 * 获取会员id
	 */
	public String getCustomerId(){
		return customerId;
	}
	/**
	* 设置会员id
	* @param customerId 会员id
	*/
	public void setCustomerId(String customerId){
		this.customerId=customerId;
	}
	/**
	 * 获取服务id
	 */
	public String getServiceId(){
		return serviceId;
	}
	/**
	* 设置服务id
	* @param serviceId 服务id
	*/
	public void setServiceId(String serviceId){
		this.serviceId=serviceId;
	}
	/**
	 * 获取次数
	 */
	public Integer getNumbers(){
		return numbers;
	}
	/**
	* 设置次数
	* @param numbers 次数
	*/
	public void setNumbers(Integer numbers){
		this.numbers=numbers;
	}
	/**
	 * 获取会员名称
	 */
	public String getCustomerName(){
		return customerName;
	}
	/**
	* 设置会员名称
	* @param customerName 会员名称
	*/
	public void setCustomerName(String customerName){
		this.customerName=customerName;
	}
	/**
	 * 获取服务名称
	 */
	public String getServiceName(){
		return serviceName;
	}
	/**
	* 设置服务名称
	* @param serviceName 服务名称
	*/
	public void setServiceName(String serviceName){
		this.serviceName=serviceName;
	}
}