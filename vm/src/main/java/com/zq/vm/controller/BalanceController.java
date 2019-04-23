package com.zq.vm.controller;

import java.util.ArrayList;
import java.util.List;
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
import com.zq.vm.entity.vo.BalanceVo;
import com.zq.vm.entity.Balance;
import com.zq.vm.entity.Customer;
import com.zq.vm.service.BalanceService;
import com.zq.vm.service.CustomerService;

/**
 * 描述: 余额控制器 
 * Time: 2019-03-25 13:45:13
 * @author: zou.qian
 * @version 1.0
 */
@Controller
public class BalanceController {

    @Autowired
    private BalanceService balanceService;
    @Autowired
    private CustomerService customerService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/balance/{id}",method = RequestMethod.GET)
    public Balance balance(@PathVariable(value = "id") String id){
        return balanceService.findOne(id);
    }


    /**
     * 保存
     * @param balance
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/balance",method = RequestMethod.POST)
    public ResultJson save(Balance balance){
        balanceService.save(balance);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param balance
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/balance",method = RequestMethod.PUT)
    public ResultJson update(Balance balance){
        balanceService.save(balance);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/balance/{id}",method = RequestMethod.DELETE)
    public ResultJson delete(@PathVariable(value = "id") String id){
        balanceService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param balance
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/balance/page",method = RequestMethod.POST)
    public Pager page(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, Balance balance){
        Page<Balance> page = balanceService.findPageByCriteria(pageNumber, pageSize, balance);
        List<BalanceVo> vo = new ArrayList<>(page.getNumberOfElements());
        for (Balance balance2 : page) {
        	Customer customer = customerService.findOne(balance2.getCustomerId());
        	vo.add(BalanceVo.build(balance2, customer.getName()));
		}
        return new Pager(vo, page.getTotalElements());
    }

    @ResponseBody
    @RequestMapping(value = "/balance/pageByCustomerName",method = RequestMethod.POST)
    public Pager pageByCustomerName(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, String customerName){
        Page<Balance> page = balanceService.findPageByCriteria(pageNumber, pageSize, customerName);
        List<BalanceVo> vo = new ArrayList<>(page.getNumberOfElements());
        for (Balance balance2 : page) {
        	Customer customer = customerService.findOne(balance2.getCustomerId());
        	vo.add(BalanceVo.build(balance2, customer.getName()));
		}
        return new Pager(vo, page.getTotalElements());
    }
    
    /**
     * 余额列表页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/balance/list")
    public String list(final Model model){
        return "balance/list";
    }

   /**
     * 新增页面
     * @return
     */
    @RequestMapping(value = "/balance/add")
    public String add(final Model model){
        return "balance/edit";
    }

    /**
     * 编辑页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/balance/edit")
    public String edit(final String id,final Model model){
        Optional.ofNullable(balanceService.findOne(id)).ifPresent(balance -> model.addAttribute("bean",balance));
        return "balance/edit";
    }
}
