package com.zq.vm.entity.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.zq.vm.entity.SetMealInformationProduct;

/**
 * 描述: 套餐商品信息表vo
 * Time: 2019-04-21 17:12:30
 * @author: zou.qian
 * @version 1.0
 */
public class SetMealInformationProductVo{
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 套餐id
	 */
	private String setMealInformationId;
	/**
	 * 商品id
	 */
	private String productId;
	/**
	 * 商品数量
	 */
	private Integer count;
	/**
	 * 类别 1->商品  2->服务
	 */
	private String type;

	/**
	 * 商品名称
	 */
	private String productName;
	
	public static SetMealInformationProductVo build(SetMealInformationProduct setMealInformationProduct,String productName){
		SetMealInformationProductVo vo = new SetMealInformationProductVo();
		BeanUtils.copyProperties(setMealInformationProduct, vo);
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
	 * 获取套餐id
	 */
	public String getSetMealInformationId(){
		return setMealInformationId;
	}
	/**
	* 设置套餐id
	* @param setMealInformationId 套餐id
	*/
	public void setSetMealInformationId(String setMealInformationId){
		this.setMealInformationId=setMealInformationId;
	}
	/**
	 * 获取商品id
	 */
	public String getProductId(){
		return productId;
	}
	/**
	* 设置商品id
	* @param productId 商品id
	*/
	public void setProductId(String productId){
		this.productId=productId;
	}
	/**
	 * 获取商品数量
	 */
	public Integer getCount(){
		return count;
	}
	/**
	* 设置商品数量
	* @param count 商品数量
	*/
	public void setCount(Integer count){
		this.count=count;
	}
	/**
	 * 获取类别 1->商品  2->服务
	 */
	public String getType(){
		return type;
	}
	/**
	* 设置类别 1->商品  2->服务
	* @param type 类别 1->商品  2->服务
	*/
	public void setType(String type){
		this.type=type;
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