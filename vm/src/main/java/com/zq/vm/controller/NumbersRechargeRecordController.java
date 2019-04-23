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
import com.zq.vm.entity.ServiceInformation;
import com.zq.vm.entity.User;
import com.zq.vm.entity.vo.NumbersRechargeRecordVo;
import com.zq.vm.entity.Customer;
import com.zq.vm.entity.NumbersRechargeRecord;
import com.zq.vm.service.CustomerService;
import com.zq.vm.service.NumbersRechargeRecordService;
import com.zq.vm.service.ServiceInformationService;
import com.zq.vm.service.UserService;
import com.zq.vm.utils.Pager;

/**
 * 描述: 服务次数充值记录表控制器 
 * Time: 2019-04-17 23:37:10
 * @author: zou.qian
 * @version 1.0
 */
@Controller
public class NumbersRechargeRecordController {
	
	private static final Logger logger = LoggerFactory.getLogger(NumbersRechargeRecordController.class);

    @Autowired
    private NumbersRechargeRecordService numbersRechargeRecordService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ServiceInformationService serviceInformationService;
    @Autowired
    private UserService userService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/numbersRechargeRecord/{id}",method = RequestMethod.GET)
    public NumbersRechargeRecord numbersRechargeRecord(@PathVariable(value = "id") String id){
        return numbersRechargeRecordService.findOne(id);
    }


    /**
     * 保存
     * @param numbersRechargeRecord
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/numbersRechargeRecord",method = RequestMethod.POST)
    public ResultJson save(NumbersRechargeRecord numbersRechargeRecord,final HttpSession session){
    	try {
    		numbersRechargeRecord.setRechargeTime(new Date());
    		numbersRechargeRecord.setCreateUserId(String.valueOf(session.getAttribute("userId")));
            numbersRechargeRecordService.saveAndDeduction(numbersRechargeRecord);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResultJson(ResultJson.ERROR, e.getMessage());
		}
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param numbersRechargeRecord
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/numbersRechargeRecord",method = RequestMethod.PUT)
    public ResultJson update(NumbersRechargeRecord numbersRechargeRecord){
        numbersRechargeRecordService.save(numbersRechargeRecord);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/numbersRechargeRecord/{id}",method = RequestMethod.DELETE)
    public ResultJson delete(@PathVariable(value = "id") String id){
        numbersRechargeRecordService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param numbersRechargeRecord
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/numbersRechargeRecord/page",method = RequestMethod.POST)
    public Pager page(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, NumbersRechargeRecord numbersRechargeRecord){
        Page<NumbersRechargeRecord> page = numbersRechargeRecordService.findPageByCriteria(pageNumber, pageSize, numbersRechargeRecord);
        List<NumbersRechargeRecordVo> vo = new ArrayList<>(page.getNumberOfElements());
        page.forEach(record -> {
        	Customer customer = customerService.findOne(record.getCustomerId());
        	String customerName = customer != null && StringUtils.isNotBlank(customer.getName())?customer.getName() : StringUtils.EMPTY;
        	ServiceInformation service = serviceInformationService.findOne(record.getServiceId());
        	String serviceName = service != null && StringUtils.isNotBlank(service.getName())?service.getName() : StringUtils.EMPTY;
        	String userName = StringUtils.EMPTY;
        	if(StringUtils.isNotBlank(record.getCreateUserId())) {
        		User user = userService.findOne(record.getCreateUserId());
            	userName = user!=null && StringUtils.isNotBlank(user.getUserName()) ? user.getUserName() : StringUtils.EMPTY;
        	}
        	vo.add(NumbersRechargeRecordVo.build(record, customerName, serviceName, userName));
    	});
        return new Pager(vo, page.getTotalElements());
    }

    /**
     * 服务次数充值记录表列表页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/numbersRechargeRecord/list")
    public String list(final Model model){
        return "numbersRechargeRecord/list";
    }

   /**
     * 新增页面
     * @return
     */
    @RequestMapping(value = "/numbersRechargeRecord/add")
    public String add(final Model model){
    	//获取没有禁用的会员集合
    	List<Customer> list = customerService.findCustomersByStatus(0);
    	model.addAttribute("customers", list);
    	//获取所有的服务
    	List<ServiceInformation> services = serviceInformationService.findAll();
    	model.addAttribute("services", services);
        return "numbersRechargeRecord/edit";
    }

    /**
     * 编辑页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/numbersRechargeRecord/edit")
    public String edit(final String id,final Model model){
        Optional.ofNullable(numbersRechargeRecordService.findOne(id)).ifPresent(numbersRechargeRecord -> model.addAttribute("bean",numbersRechargeRecord));
        return "numbersRechargeRecord/edit";
    }
}
