package com.zq.vm.controller;

import com.zq.vm.entity.ResultJson;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.CustomerNumbers;
import com.zq.vm.service.CustomerNumbersService;

/**
 * 描述: 余额信息控制器 
 * Time: 2019-02-24 18:46:04
 * @author: zou.qian
 * @version 1.0
 */
@Controller
@RequestMapping(value = "customerNumbers")
public class CustomerNumbersController {

   @Autowired
    private CustomerNumbersService customerNumbersService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public CustomerNumbers customerNumbers(@PathVariable(value = "id") String id){
        return customerNumbersService.findOne(id);
    }


    /**
     * 保存
     * @param customerNumbers
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResultJson save(CustomerNumbers customerNumbers){
        customerNumbersService.save(customerNumbers);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param customerNumbers
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public ResultJson update(CustomerNumbers customerNumbers){
        customerNumbersService.save(customerNumbers);
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
        customerNumbersService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param customerNumbers
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/page/{pageNumber}/{pageSize}",method = RequestMethod.POST)
    public ResultJson page(@PathVariable(value = "pageNumber") Integer pageNumber,@PathVariable(value = "pageSize") Integer pageSize,CustomerNumbers customerNumbers){
        Page<CustomerNumbers> page = customerNumbersService.findPageByCriteria(pageNumber, pageSize, customerNumbers);
    	return new ResultJson(ResultJson.SUCCESS,"操作成功！", page);
    }

}
