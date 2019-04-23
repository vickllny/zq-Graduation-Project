package com.zq.vm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.zq.vm.entity.SetMealInformation;
import com.zq.vm.entity.User;
import com.zq.vm.entity.vo.CustomerSetMealProductionVo;
import com.zq.vm.entity.vo.CustomerSetMealVo;
import com.zq.vm.entity.Customer;
import com.zq.vm.entity.CustomerSetMeal;
import com.zq.vm.entity.ProductInformation;
import com.zq.vm.service.CustomerService;
import com.zq.vm.service.CustomerSetMealProductionService;
import com.zq.vm.service.CustomerSetMealService;
import com.zq.vm.service.SetMealInformationService;
import com.zq.vm.service.UserService;
import com.zq.vm.utils.Pager;

/**
 * 描述: 会员套餐关系表控制器 
 * Time: 2019-04-22 23:40:19
 * @author: zou.qian
 * @version 1.0
 */
@Controller
public class CustomerSetMealController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerSetMealController.class);

    @Autowired
    private CustomerSetMealService customerSetMealService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SetMealInformationService setMealInformationService;
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerSetMealProductionService customerSetMealProductionService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/customerSetMeal/{id}",method = RequestMethod.GET)
    public CustomerSetMeal customerSetMeal(@PathVariable(value = "id") String id){
        return customerSetMealService.findOne(id);
    }


    /**
     * 保存
     * @param customerSetMeal
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/customerSetMeal",method = RequestMethod.POST)
    public ResultJson save(CustomerSetMeal customerSetMeal,final HttpSession session){
    	try {
    		customerSetMeal.setCreateTime(new Date());
        	customerSetMeal.setCreateUserId(String.valueOf(session.getAttribute("userId")));
            customerSetMealService.saveAndDeduction(customerSetMeal);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			return new ResultJson(ResultJson.ERROR, e.getMessage());
		}
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param customerSetMeal
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/customerSetMeal",method = RequestMethod.PUT)
    public ResultJson update(CustomerSetMeal customerSetMeal){
        customerSetMealService.save(customerSetMeal);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/customerSetMeal/{id}",method = RequestMethod.DELETE)
    public ResultJson delete(@PathVariable(value = "id") String id){
        customerSetMealService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param customerSetMeal
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/customerSetMeal/page",method = RequestMethod.POST)
    public Pager page(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, CustomerSetMeal customerSetMeal){
        Page<CustomerSetMeal> page = customerSetMealService.findPageByCriteria(pageNumber, pageSize, customerSetMeal);
        List<CustomerSetMealVo> vo = new ArrayList<>(page.getNumberOfElements());
        page.forEach(bean -> {
        	Customer customer = customerService.findOne(bean.getCustomerId());
        	User user = userService.findOne(bean.getCreateUserId());
        	String userName = user!=null && StringUtils.isNotBlank(user.getUserName()) ? user.getUserName() : StringUtils.EMPTY;
        	SetMealInformation setMealInformation = setMealInformationService.findOne(bean.getSetMealId());
        	vo.add(CustomerSetMealVo.build(bean, customer.getName(), setMealInformation.getName(), userName));
        });
        return new Pager(vo, page.getTotalElements());
    }

    /**
     * 会员套餐关系表列表页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/customerSetMeal/list")
    public String list(final Model model){
        return "/customerSetMeal/list";
    }

   /**
     * 新增页面
     * @return
     */
    @RequestMapping(value = "/customerSetMeal/add")
    public String add(final Model model){
    	model.addAttribute("customers", customerService.findAll());
    	model.addAttribute("setMeals", setMealInformationService.findAll());
        return "/customerSetMeal/edit";
    }

    /**
     * 编辑页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/customerSetMeal/edit")
    public String edit(final String id,final Model model){
        Optional.ofNullable(customerSetMealService.findOne(id)).ifPresent(customerSetMeal -> model.addAttribute("bean",customerSetMeal));
        return "/customerSetMeal/edit";
    }
    
    /**
     * 套餐详情查看
     * @param model
     * @param setMealId
     * @return
     */
    @RequestMapping(value = "/customerSetMeal/viewSetMealDetail")
    public String viewSetMealDetail(final Model model,final String setMealId) {
    	model.addAttribute("setMealId", setMealId);
    	return "/customerSetMeal/setMealDetail";
    }
    
    /**
     * 套餐商品查看
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/customerSetMeal/deduction/{id}")
    public String deduction(final Model model,@PathVariable(value = "id")final String id) {
    	model.addAttribute("id", id);
    	return "/customerSetMeal/deduction";
    }
    
    /**
     * 获取已购套餐下的商品
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/customerSetMeal/deduction")
    public List<CustomerSetMealProductionVo> deduction(final String id) {
    	List<CustomerSetMealProductionVo> vo = customerSetMealProductionService.findVoByCustomerSetMealId(id);
    	return vo;
    }
}
