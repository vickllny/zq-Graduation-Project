package com.zq.vm.entity.vo;

import java.util.List;

import com.zq.vm.entity.SetMealInformationProduct;

/**
 * 套餐关联商品信息vo
 * @author admin
 *
 */
public class SetMealInformationVo {
	
	private List<SetMealInformationProduct> data;
	
	private String id;

	public SetMealInformationVo() {
		super();
	}

	public List<SetMealInformationProduct> getData() {
		return data;
	}

	public void setData(List<SetMealInformationProduct> data) {
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
