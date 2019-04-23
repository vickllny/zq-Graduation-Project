package com.zq.vm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
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
import com.zq.vm.entity.ServiceInformation;
import com.zq.vm.entity.vo.NumbersVo;
import com.zq.vm.entity.Customer;
import com.zq.vm.entity.Numbers;
import com.zq.vm.service.CustomerService;
import com.zq.vm.service.NumbersService;
import com.zq.vm.service.ServiceInformationService;
import com.zq.vm.utils.Pager;

/**
 * 描述: 会员次数记录表控制器 
 * Time: 2019-04-20 21:55:56
 * @author: zou.qian
 * @version 1.0
 */
@Controller
public class NumbersController {

    @Autowired
    private NumbersService numbersService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ServiceInformationService serviceInformationService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/numbers/{id}",method = RequestMethod.GET)
    public Numbers numbers(@PathVariable(value = "id") String id){
        return numbersService.findOne(id);
    }


    /**
     * 保存
     * @param numbers
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/numbers",method = RequestMethod.POST)
    public ResultJson save(Numbers numbers){
        numbersService.save(numbers);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param numbers
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/numbers",method = RequestMethod.PUT)
    public ResultJson update(Numbers numbers){
        numbersService.save(numbers);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/numbers/{id}",method = RequestMethod.DELETE)
    public ResultJson delete(@PathVariable(value = "id") String id){
        numbersService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param numbers
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/numbers/page",method = RequestMethod.POST)
    public Pager page(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, Numbers numbers){
        Page<Numbers> page = numbersService.findPageByCriteria(pageNumber, pageSize, numbers);
        List<NumbersVo> vo = new ArrayList<>(page.getNumberOfElements());
        page.forEach(bean -> {
        	Customer customer = customerService.findOne(bean.getCustomerId());
        	String customerName = customer != null && StringUtils.isNotBlank(customer.getName())?customer.getName() : StringUtils.EMPTY;
        	ServiceInformation service = serviceInformationService.findOne(bean.getServiceId());
        	String serviceName = service != null && StringUtils.isNotBlank(service.getName())?service.getName() : StringUtils.EMPTY;
        	vo.add(NumbersVo.build(bean, customerName, serviceName));
        });
        return new Pager(vo, page.getTotalElements());
    }

    /**
     * 会员次数记录表列表页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/numbers/list")
    public String list(final Model model){
        return "numbers/list";
    }

   /**
     * 新增页面
     * @return
     */
    @RequestMapping(value = "/numbers/add")
    public String add(final Model model){
        return "numbers/edit";
    }

    /**
     * 编辑页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/numbers/edit")
    public String edit(final String id,final Model model){
        Optional.ofNullable(numbersService.findOne(id)).ifPresent(numbers -> model.addAttribute("bean",numbers));
        return "numbers/edit";
    }
}
