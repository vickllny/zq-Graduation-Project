package com.zq.vm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.zq.vm.entity.AmountRechargeRecord;
import com.zq.vm.entity.Customer;
import com.zq.vm.service.AmountRechargeRecordService;
import com.zq.vm.service.CustomerService;
import com.zq.vm.service.CustomerSetMealService;
import com.zq.vm.utils.Pager;
import com.zq.vm.utils.SpringContextUtil;

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
import com.zq.vm.entity.vo.AmountRechargeRecordVo;

/**
 * 描述: 余额充值记录控制器 
 * Time: 2019-03-23 12:49:34
 * @author: zou.qian
 * @version 1.0
 */
@Controller
public class AmountRechargeRecordController {

    @Autowired
    private AmountRechargeRecordService amountRechargeRecordService;
    @Autowired
    private CustomerService customerService;
    
//    private CustomerSetMealService customerSetMealService = SpringContextUtil.getBean(CustomerSetMealService.class);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/amountRechargeRecord/{id}",method = RequestMethod.GET)
    public AmountRechargeRecord amountRechargeRecord(@PathVariable(value = "id") String id){
        return amountRechargeRecordService.findOne(id);
    }


    /**
     * 保存
     * @param amountRechargeRecord
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/amountRechargeRecord",method = RequestMethod.POST)
    public ResultJson save(AmountRechargeRecord amountRechargeRecord){
        amountRechargeRecord.setRechargeTime(new Date());
        amountRechargeRecordService.save(amountRechargeRecord);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param amountRechargeRecord
     * @return
     */
    //@ResponseBody
    //@RequestMapping(value = "/amountRechargeRecord",method = RequestMethod.PUT)
    public ResultJson update(AmountRechargeRecord amountRechargeRecord){
        amountRechargeRecord.setRechargeTime(new Date());
        amountRechargeRecordService.save(amountRechargeRecord);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    //@ResponseBody
    //@RequestMapping(value = "/amountRechargeRecord/{id}",method = RequestMethod.DELETE)
    public ResultJson delete(@PathVariable(value = "id") String id){
        amountRechargeRecordService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param amountRechargeRecord
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/amountRechargeRecord/page",method = RequestMethod.POST)
    public Pager page(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, AmountRechargeRecord amountRechargeRecord){
        Page<AmountRechargeRecord> page = amountRechargeRecordService.findPageByCriteria(pageNumber, pageSize, amountRechargeRecord);
        List<AmountRechargeRecordVo> vo = new ArrayList<>(page.getNumberOfElements());
        for (AmountRechargeRecord amountRechargeRecord2 : page) {
			Customer customer = customerService.findOne(amountRechargeRecord2.getCustomerId());
			vo.add(AmountRechargeRecordVo.build(amountRechargeRecord2, customer.getName()));
		}
        return new Pager(vo, page.getTotalElements());
    }

    /**
     * 余额充值记录列表页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/amountRechargeRecord/list")
    public String list(final Model model){
        return "amountRechargeRecord/list";
    }

   /**
     * 新增页面
     * @return
     */
    @RequestMapping(value = "/amountRechargeRecord/add")
    public String add(final Model model){
    	//获取没有禁用的会员集合
    	List<Customer> list = customerService.findCustomersByStatus(0);
    	model.addAttribute("list", list);
        return "amountRechargeRecord/edit";
    }

    /**
     * 编辑页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/amountRechargeRecord/edit")
    public String edit(final String id,final Model model){
        Optional.ofNullable(amountRechargeRecordService.findOne(id)).ifPresent(amountRechargeRecord -> model.addAttribute("bean",amountRechargeRecord));
        return "amountRechargeRecord/edit";
    }
    
    /**
     * 查看
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/amountRechargeRecord/view")
    public String view(final String id,final Model model){
        Optional.ofNullable(amountRechargeRecordService.findOne(id)).ifPresent(amountRechargeRecord -> {
        	model.addAttribute("bean",amountRechargeRecord);
        	Customer customer = customerService.findOne(amountRechargeRecord.getCustomerId());
        	model.addAttribute("customerName", customer.getName());
        });
        return "amountRechargeRecord/view";
    }
}
