package com.zq.vm.controller;

import com.zq.vm.entity.ResultJson;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.Customer;
import com.zq.vm.service.CustomerService;

/**
 * 描述: 会员信息控制器 
 * Time: 2019-02-24 14:58:24
 * @author: zou.qian
 * @version 1.0
 */
@Controller
@RequestMapping(value = "customer")
public class CustomerController {

   @Autowired
    private CustomerService customerService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Customer customer(@PathVariable(value = "id") String id){
        return customerService.findOne(id);
    }


    /**
     * 保存
     * @param customer
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResultJson save(Customer customer){
        customerService.save(customer);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param customer
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public ResultJson update(Customer customer){
        customerService.save(customer);
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
        customerService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param customer
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/page/{pageNumber}/{pageSize}",method = RequestMethod.POST)
    public ResultJson page(@PathVariable(value = "pageNumber") Integer pageNumber,@PathVariable(value = "pageSize") Integer pageSize,Customer customer){
        Page<Customer> page = customerService.findPageByCriteria(pageNumber, pageSize, customer);
    	return new ResultJson(ResultJson.SUCCESS,"操作成功！", page);
    }

}
