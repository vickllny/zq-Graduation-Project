package com.zq.vm.controller;

import java.util.Optional;

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
import com.zq.vm.entity.CustomerSetMealProduction;
import com.zq.vm.service.CustomerSetMealProductionService;
import com.zq.vm.utils.Pager;

/**
 * 描述: 会员套餐商品关系表控制器 
 * Time: 2019-04-23 22:04:24
 * @author: zou.qian
 * @version 1.0
 */
@Controller
public class CustomerSetMealProductionController {

    @Autowired
    private CustomerSetMealProductionService customerSetMealProductionService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/customerSetMealProduction/{id}",method = RequestMethod.GET)
    public CustomerSetMealProduction customerSetMealProduction(@PathVariable(value = "id") String id){
        return customerSetMealProductionService.findOne(id);
    }


    /**
     * 保存
     * @param customerSetMealProduction
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/customerSetMealProduction",method = RequestMethod.POST)
    public ResultJson save(CustomerSetMealProduction customerSetMealProduction){
        customerSetMealProductionService.save(customerSetMealProduction);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param customerSetMealProduction
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/customerSetMealProduction",method = RequestMethod.PUT)
    public ResultJson update(CustomerSetMealProduction customerSetMealProduction){
        customerSetMealProductionService.save(customerSetMealProduction);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/customerSetMealProduction/{id}",method = RequestMethod.DELETE)
    public ResultJson delete(@PathVariable(value = "id") String id){
        customerSetMealProductionService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param customerSetMealProduction
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/customerSetMealProduction/page",method = RequestMethod.POST)
    public Pager page(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, CustomerSetMealProduction customerSetMealProduction){
        Page<CustomerSetMealProduction> page = customerSetMealProductionService.findPageByCriteria(pageNumber, pageSize, customerSetMealProduction);
        return new Pager(page.getContent(), page.getTotalElements());
    }

    /**
     * 会员套餐商品关系表列表页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/customerSetMealProduction/list")
    public String list(final Model model){
        return "/customerSetMealProduction/list";
    }

   /**
     * 新增页面
     * @return
     */
    @RequestMapping(value = "/customerSetMealProduction/add")
    public String add(final Model model){
        return "/customerSetMealProduction/edit";
    }

    /**
     * 编辑页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/customerSetMealProduction/edit")
    public String edit(final String id,final Model model){
        Optional.ofNullable(customerSetMealProductionService.findOne(id)).ifPresent(customerSetMealProduction -> model.addAttribute("bean",customerSetMealProduction));
        return "/customerSetMealProduction/edit";
    }
}
