package com.zq.vm.service;

import com.zq.vm.entity.SetMealInformation;
import com.zq.vm.entity.vo.SetMealInformationVo;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 描述: 套餐管理业务接口
 * Time: 2019-03-25 22:25:50
 * @author: zou.qian
 * @version 1.0
 */
public interface SetMealInformationService{

    /**
     * 保存
     * @param setMealInformation
     * @return
     */
	SetMealInformation save(SetMealInformation setMealInformation);

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
     * @param setMealInformation
     * @return
     */
    Page<SetMealInformation> findPageByCriteria(int pageNumber, int pageSize, SetMealInformation setMealInformation);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	SetMealInformation findOne(String id);

    /**
     * 查询所有
     * @return
     */
    List<SetMealInformation> findAll();

    /**
     * 保存套餐的商品
     * @param vo
     */
	void saveProduct(SetMealInformationVo vo);
}
