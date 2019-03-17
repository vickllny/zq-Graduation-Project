package com.zq.vm.controller;

import com.zq.vm.entity.ResultJson;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.ProductStockPurchase;
import com.zq.vm.service.ProductStockPurchaseService;

/**
 * 描述: 余额信息控制器 
 * Time: 2019-02-24 19:00:38
 * @author: zou.qian
 * @version 1.0
 */
@Controller
@RequestMapping(value = "productStockPurchase")
public class ProductStockPurchaseController {

   @Autowired
    private ProductStockPurchaseService productStockPurchaseService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ProductStockPurchase productStockPurchase(@PathVariable(value = "id") String id){
        return productStockPurchaseService.findOne(id);
    }


    /**
     * 保存
     * @param productStockPurchase
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResultJson save(ProductStockPurchase productStockPurchase){
        productStockPurchaseService.save(productStockPurchase);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param productStockPurchase
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public ResultJson update(ProductStockPurchase productStockPurchase){
        productStockPurchaseService.save(productStockPurchase);
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
        productStockPurchaseService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param productStockPurchase
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/page/{pageNumber}/{pageSize}",method = RequestMethod.POST)
    public ResultJson page(@PathVariable(value = "pageNumber") Integer pageNumber,@PathVariable(value = "pageSize") Integer pageSize,ProductStockPurchase productStockPurchase){
        Page<ProductStockPurchase> page = productStockPurchaseService.findPageByCriteria(pageNumber, pageSize, productStockPurchase);
    	return new ResultJson(ResultJson.SUCCESS,"操作成功！", page);
    }

}
