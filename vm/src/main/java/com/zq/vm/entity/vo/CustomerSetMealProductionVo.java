package com.zq.vm.entity.vo;

import org.springframework.beans.BeanUtils;

import com.zq.vm.entity.CustomerSetMealProduction;

/**
 * 描述: 会员套餐商品关系表vo
 * Time: 2019-04-23 22:04:24
 * @author: zou.qian
 * @version 1.0
 */
public class CustomerSetMealProductionVo{
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 会员id
	 */
	private String customerId;
	/**
	 * 套餐id
	 */
	private String setMealId;
	/**
	 * 
	 */
	private String customerSetMealId;
	/**
	 * 
	 */
	private String productId;
	/**
	 * 1->商品  2->服务
	 */
	private String type;
	/**
	 * 数量
	 */
	private Integer count;

	/**
	 * 会员名称
	 */
	private String customerName;
	/**
	 * 套餐名称
	 */
	private String setMealName;
	/**
	 * 商品名称
	 */
	private String productName;
	
	public static CustomerSetMealProductionVo build(CustomerSetMealProduction customerSetMealProduction,String customerName,String setMealName,String productName){
		CustomerSetMealProductionVo vo = new CustomerSetMealProductionVo();
		BeanUtils.copyProperties(customerSetMealProduction, vo);
		vo.customerName = customerName;
		vo.setMealName = setMealName;
		vo.productName = productName;
		return vo;
	}
	
	public static CustomerSetMealProductionVo build(CustomerSetMealProduction customerSetMealProduction,String productName){
		CustomerSetMealProductionVo vo = new CustomerSetMealProductionVo();
		BeanUtils.copyProperties(customerSetMealProduction, vo);
		vo.productName = productName;
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
	 * 获取套餐id
	 */
	public String getSetMealId(){
		return setMealId;
	}
	/**
	* 设置套餐id
	* @param setMealId 套餐id
	*/
	public void setSetMealId(String setMealId){
		this.setMealId=setMealId;
	}
	/**
	 * 获取
	 */
	public String getCustomerSetMealId(){
		return customerSetMealId;
	}
	/**
	* 设置
	* @param customerSetMealId 
	*/
	public void setCustomerSetMealId(String customerSetMealId){
		this.customerSetMealId=customerSetMealId;
	}
	/**
	 * 获取
	 */
	public String getProductId(){
		return productId;
	}
	/**
	* 设置
	* @param productId 
	*/
	public void setProductId(String productId){
		this.productId=productId;
	}
	/**
	 * 获取1->商品  2->服务
	 */
	public String getType(){
		return type;
	}
	/**
	* 设置1->商品  2->服务
	* @param type 1->商品  2->服务
	*/
	public void setType(String type){
		this.type=type;
	}
	/**
	 * 获取数量
	 */
	public Integer getCount(){
		return count;
	}
	/**
	* 设置数量
	* @param count 数量
	*/
	public void setCount(Integer count){
		this.count=count;
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
	 * 获取套餐名称
	 */
	public String getSetMealName(){
		return setMealName;
	}
	/**
	* 设置套餐名称
	* @param setMealName 套餐名称
	*/
	public void setSetMealName(String setMealName){
		this.setMealName=setMealName;
	}
	/**
	 * 获取商品名称
	 */
	public String getProductName(){
		return productName;
	}
	/**
	* 设置商品名称
	* @param productName 商品名称
	*/
	public void setProductName(String productName){
		this.productName=productName;
	}
}