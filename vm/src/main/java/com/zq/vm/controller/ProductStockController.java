package com.zq.vm.controller;

import com.zq.vm.entity.ResultJson;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.ProductStock;
import com.zq.vm.service.ProductStockService;

/**
 * 描述: 余额信息控制器 
 * Time: 2019-02-24 18:55:51
 * @author: zou.qian
 * @version 1.0
 */
@Controller
@RequestMapping(value = "productStock")
public class ProductStockController {

   @Autowired
    private ProductStockService productStockService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ProductStock productStock(@PathVariable(value = "id") String id){
        return productStockService.findOne(id);
    }


    /**
     * 保存
     * @param productStock
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResultJson save(ProductStock productStock){
        productStockService.save(productStock);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param productStock
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public ResultJson update(ProductStock productStock){
        productStockService.save(productStock);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResultJson delete(@PathVariable(value = "id") String id){
        productStockService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param productStock
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/page/{pageNumber}/{pageSize}",method = RequestMethod.POST)
    public ResultJson page(@PathVariable(value = "pageNumber") Integer pageNumber,@PathVariable(value = "pageSize") Integer pageSize,ProductStock productStock){
        Page<ProductStock> page = productStockService.findPageByCriteria(pageNumber, pageSize, productStock);
    	return new ResultJson(ResultJson.SUCCESS,"操作成功！", page);
    }

}
