package com.zq.vm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.zq.vm.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zq.vm.entity.ResultJson;
import com.zq.vm.entity.vo.CustomerBusinessVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zq.vm.entity.Customer;
import com.zq.vm.service.CustomerService;

/**
 * 描述: 会员控制器 
 * Time: 2019-03-25 14:23:23
 * @author: zou.qian
 * @version 1.0
 */
@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/customer/{id}",method = RequestMethod.GET)
    public Customer customer(@PathVariable(value = "id") String id){
        return customerService.findOne(id);
    }


    /**
     * 保存
     * @param customer
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/customer",method = RequestMethod.POST)
    public ResultJson save(Customer customer){
    	customer.setCreateTime(new Date());
        customerService.save(customer);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param customer
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/customer",method = RequestMethod.PUT)
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
    @RequestMapping(value = "/customer/{id}",method = RequestMethod.DELETE)
    public ResultJson delete(@PathVariable(value = "id") String id){
        Optional.ofNullable(customerService.findOne(id)).ifPresent(customer -> {
        	int op = customer.getDel() == 1?0:1;
        	customer.setDel(op);
        	customerService.save(customer);
        });;
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
    @RequestMapping(value = "/customer/page",method = RequestMethod.POST)
    public Pager page(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, Customer customer){
        Page<Customer> page = customerService.findPageByCriteria(pageNumber, pageSize, customer);
        return new Pager(page.getContent(), page.getTotalElements());
    }

    /**
     * 会员列表页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/customer/list")
    public String list(final Model model){
        return "customer/list";
    }

   /**
     * 新增页面
     * @return
     */
    @RequestMapping(value = "/customer/add")
    public String add(final Model model){
        return "customer/edit";
    }

    /**
     * 编辑页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/customer/edit")
    public String edit(final String id,final Model model){
        Optional.ofNullable(customerService.findOne(id)).ifPresent(customer -> model.addAttribute("bean",customer));
        return "customer/edit";
    }
    
    /**
     * 会员注册统计页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/customer/registerList")
    public String registerList(final Model model){
        return "customer/registerList";
    }
    
    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param customer
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/customer/registerPage",method = RequestMethod.POST)
    public Pager registerPage(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, String createTime){
        Page<Customer> page = customerService.findPageByCreateTime(pageNumber, pageSize, createTime);
        return new Pager(page.getContent(), page.getTotalElements());
    }
    
    /**
     * 会员业务单据统计
     * @param model
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value = "/customer/businessList")
    public String businessList(final Model model) throws JsonProcessingException{
    	//类型map
    	Map<String, String> typeMap = new HashMap<>();
    	typeMap.put("service", "服务");
    	typeMap.put("product", "商品");
    	typeMap.put("setMeal", "套餐");
    	ObjectMapper objectMapper = new ObjectMapper();
    	
    	model.addAttribute("typeMapJson", objectMapper.writeValueAsString(typeMap));
    	model.addAttribute("typeMap", typeMap);
    	//所有会员
    	model.addAttribute("customers", customerService.findAll());
    	return "customer/businessList";
    }
    
    /**
     * 业务单据分页查询
     * @param pageNumber
     * @param pageSize
     * @param customerId
     * @param type
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/customer/businessPage",method = RequestMethod.POST)
    public Pager businessPage(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, 
    		String customerId,String type){
        Page<Object[]> page = customerService.findPageByCustomerIdAndType(pageNumber, pageSize, customerId, type);
        List<CustomerBusinessVo> vo = new ArrayList<>(page.getNumberOfElements());
        page.forEach(array -> {
        	vo.add(CustomerBusinessVo.build(array));
        });
        return new Pager(vo, page.getTotalElements());
    }
    
    /**
     * 会员消费统计排行
     * @param model
     * @return
     */
    @RequestMapping(value = "/customer/consumeRank")
    public String consumeRank(final Model model){
        return "customer/consumeRankList";
    }
    
    /**
     * 消费排行
     * @param pageNumber
     * @param pageSize
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/customer/consumeRankPage",method = RequestMethod.POST)
    public Pager consumeRankPage(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, 
    		String name){
        Page<Object[]> page = customerService.findConsumeRankPage(pageNumber, pageSize, name);
        List<CustomerBusinessVo> vo = new ArrayList<>(page.getNumberOfElements());
        page.forEach(array -> {
        	vo.add(CustomerBusinessVo.buildRank(array));
        });
        return new Pager(vo, page.getTotalElements());
    }
    
    /**
     * 会员生日提醒页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/customer/birthRemind")
    public String birthRemind(final Model model){
        return "customer/birthRemindList";
    }
    
    /**
     * 生日提醒分页数据
     * @param pageNumber
     * @param pageSize
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/customer/birthRemindPage",method = RequestMethod.POST)
    public Pager birthRemindPage(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, String name){
        Date nowDate = new Date();
    	Page<Customer> page = customerService.findBirthRemindPage(pageNumber, pageSize, nowDate, name);
        return new Pager(page.getContent(), page.getTotalElements());
    }
}
