/**
 * 
 */
package com.zq.vm.entity.vo;

/**
 * 商品信息vo
 * @author zou.qian
 *
 */
public class ProductInformationVo {
	private String id;
	private String name;
	private Integer count;
	
	public static ProductInformationVo build(Object[] array) {
		ProductInformationVo vo = new ProductInformationVo();
		vo.setId(String.valueOf(array[0]));
		vo.setName(String.valueOf(array[1]));
		vo.setCount(Integer.valueOf(String.valueOf(array[2])));
		return vo;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
}
