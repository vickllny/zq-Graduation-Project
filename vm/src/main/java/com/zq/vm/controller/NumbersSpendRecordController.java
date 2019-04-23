package com.zq.vm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

import com.zq.vm.entity.Customer;
import com.zq.vm.entity.NumbersSpendRecord;
import com.zq.vm.entity.ResultJson;
import com.zq.vm.entity.ServiceInformation;
import com.zq.vm.entity.vo.NumbersSpendRecordVo;
import com.zq.vm.service.CustomerService;
import com.zq.vm.service.NumbersSpendRecordService;
import com.zq.vm.service.ServiceInformationService;
import com.zq.vm.utils.Pager;

/**
 * 描述: 服务次数消费记录表控制器 
 * Time: 2019-04-20 20:55:46
 * @author: zou.qian
 * @version 1.0
 */
@Controller
public class NumbersSpendRecordController {
	
	private static final Logger logger = LoggerFactory.getLogger(NumbersSpendRecordController.class);

    @Autowired
    private NumbersSpendRecordService numbersSpendRecordService;
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
    @RequestMapping(value = "/numbersSpendRecord/{id}",method = RequestMethod.GET)
    public NumbersSpendRecord numbersSpendRecord(@PathVariable(value = "id") String id){
        return numbersSpendRecordService.findOne(id);
    }


    /**
     * 保存
     * @param numbersSpendRecord
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/numbersSpendRecord",method = RequestMethod.POST)
    public ResultJson save(NumbersSpendRecord numbersSpendRecord){
    	try {
    		numbersSpendRecord.setSpendTime(new Date());
            numbersSpendRecordService.saveAndDeductionNumbers(numbersSpendRecord);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResultJson(ResultJson.ERROR, e.getMessage());
		}
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param numbersSpendRecord
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/numbersSpendRecord",method = RequestMethod.PUT)
    public ResultJson update(NumbersSpendRecord numbersSpendRecord){
        numbersSpendRecordService.save(numbersSpendRecord);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/numbersSpendRecord/{id}",method = RequestMethod.DELETE)
    public ResultJson delete(@PathVariable(value = "id") String id){
        numbersSpendRecordService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param numbersSpendRecord
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/numbersSpendRecord/page",method = RequestMethod.POST)
    public Pager page(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, NumbersSpendRecord numbersSpendRecord){
        Page<NumbersSpendRecord> page = numbersSpendRecordService.findPageByCriteria(pageNumber, pageSize, numbersSpendRecord);
        List<NumbersSpendRecordVo> vo = new ArrayList<>(page.getNumberOfElements());
        page.forEach(bean -> {
        	Customer customer = customerService.findOne(bean.getCustomerId());
        	String customerName = customer!=null && StringUtils.isNotBlank(customer.getName()) ? customer.getName() : StringUtils.EMPTY;
        	ServiceInformation service = serviceInformationService.findOne(bean.getServiceId());
        	String serviceName = service!=null && StringUtils.isNotBlank(service.getName()) ? service.getName() : StringUtils.EMPTY;
        	vo.add(NumbersSpendRecordVo.build(bean, customerName, serviceName));
        });
        return new Pager(vo, page.getTotalElements());
    }

    /**
     * 服务次数消费记录表列表页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/numbersSpendRecord/list")
    public String list(final Model model){
        return "numbersSpendRecord/list";
    }

   /**
     * 新增页面
     * @return
     */
    @RequestMapping(value = "/numbersSpendRecord/add")
    public String add(final Model model){
    	//获取没有禁用的会员集合
    	List<Customer> list = customerService.findCustomersByStatus(0);
    	model.addAttribute("customers", list);
    	//获取所有的服务
    	List<ServiceInformation> services = serviceInformationService.findAll();
    	model.addAttribute("services", services);
        return "numbersSpendRecord/edit";
    }

    /**
     * 编辑页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/numbersSpendRecord/edit")
    public String edit(final String id,final Model model){
        Optional.ofNullable(numbersSpendRecordService.findOne(id)).ifPresent(numbersSpendRecord -> model.addAttribute("bean",numbersSpendRecord));
        return "numbersSpendRecord/edit";
    }
}
