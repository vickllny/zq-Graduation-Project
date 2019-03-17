package com.zq.vm.controller;

import com.zq.vm.entity.ResultJson;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.ProductStockOut;
import com.zq.vm.service.ProductStockOutService;

/**
 * 描述: 余额信息控制器 
 * Time: 2019-02-24 18:58:30
 * @author: zou.qian
 * @version 1.0
 */
@Controller
@RequestMapping(value = "productStockOut")
public class ProductStockOutController {

   @Autowired
    private ProductStockOutService productStockOutService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ProductStockOut productStockOut(@PathVariable(value = "id") String id){
        return productStockOutService.findOne(id);
    }


    /**
     * 保存
     * @param productStockOut
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResultJson save(ProductStockOut productStockOut){
        productStockOutService.save(productStockOut);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param productStockOut
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public ResultJson update(ProductStockOut productStockOut){
        productStockOutService.save(productStockOut);
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
        productStockOutService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param productStockOut
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/page/{pageNumber}/{pageSize}",method = RequestMethod.POST)
    public ResultJson page(@PathVariable(value = "pageNumber") Integer pageNumber,@PathVariable(value = "pageSize") Integer pageSize,ProductStockOut productStockOut){
        Page<ProductStockOut> page = productStockOutService.findPageByCriteria(pageNumber, pageSize, productStockOut);
    	return new ResultJson(ResultJson.SUCCESS,"操作成功！", page);
    }

}
