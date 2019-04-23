package com.zq.vm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import com.zq.vm.utils.Pager;

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
import com.zq.vm.entity.User;
import com.zq.vm.entity.vo.AmountSpendRecordVo;
import com.zq.vm.entity.AmountSpendRecord;
import com.zq.vm.entity.Balance;
import com.zq.vm.entity.Customer;
import com.zq.vm.entity.ProductInformation;
import com.zq.vm.service.AmountSpendRecordService;
import com.zq.vm.service.BalanceService;
import com.zq.vm.service.CustomerService;
import com.zq.vm.service.ProductInformationService;
import com.zq.vm.service.UserService;

/**
 * 描述: 余额充值记录控制器 
 * Time: 2019-03-23 13:44:04
 * @author: zou.qian
 * @version 1.0
 */
@Controller
public class AmountSpendRecordController {

    @Autowired
    private AmountSpendRecordService amountSpendRecordService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductInformationService productInformationService;
    @Autowired
    private BalanceService balanceService;
    @Autowired
    private UserService userService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/amountSpendRecord/{id}",method = RequestMethod.GET)
    public AmountSpendRecord amountSpendRecord(@PathVariable(value = "id") String id){
        return amountSpendRecordService.findOne(id);
    }


    /**
     * 保存
     * @param amountSpendRecord
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/amountSpendRecord",method = RequestMethod.POST)
    public ResultJson save(AmountSpendRecord amountSpendRecord,final HttpSession session){
    	ProductInformation product = productInformationService.findOne(amountSpendRecord.getProductId());
    	if(product.getQuantity() < amountSpendRecord.getCount()) {
    		return new ResultJson(ResultJson.ERROR,"操作失败，库存不足！");
    	}
    	
        Balance balance = balanceService.findByCustomerId(amountSpendRecord.getCustomerId());
        if(balance.getBalance().compareTo(amountSpendRecord.getAmountSpend()) == -1) {
        	return new ResultJson(ResultJson.ERROR,"操作失败，会员余额不足！");
        }
        String userId = String.valueOf(session.getAttribute("userId"));
        amountSpendRecord.setCreateUserId(userId);
        amountSpendRecord.setSpendTime(new Date());
        amountSpendRecordService.save(amountSpendRecord);
        
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param amountSpendRecord
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/amountSpendRecord",method = RequestMethod.PUT)
    public ResultJson update(AmountSpendRecord amountSpendRecord){
        amountSpendRecord.setSpendTime(new Date());
        amountSpendRecordService.save(amountSpendRecord);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/amountSpendRecord/{id}",method = RequestMethod.DELETE)
    public ResultJson delete(@PathVariable(value = "id") String id){
        amountSpendRecordService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param amountSpendRecord
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/amountSpendRecord/page",method = RequestMethod.POST)
    public Pager page(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, AmountSpendRecord amountSpendRecord){
        Page<AmountSpendRecord> page = amountSpendRecordService.findPageByCriteria(pageNumber, pageSize, amountSpendRecord);
        return new Pager(page.getContent(), page.getTotalElements());
    }
    
    @ResponseBody
    @RequestMapping(value = "/amountSpendRecord/searchPage",method = RequestMethod.POST)
    public Pager searchPage(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, AmountSpendRecordVo amountSpendRecord){
        Page<AmountSpendRecord> page = amountSpendRecordService.findPageByCriteria(pageNumber, pageSize, amountSpendRecord);
        List<AmountSpendRecordVo> list = new ArrayList<>(page.getNumberOfElements());
        page.forEach(record -> {
        	Customer customer = customerService.findOne(record.getCustomerId());
        	ProductInformation product = productInformationService.findOne(record.getProductId());
        	User user = userService.findOne(record.getCreateUserId());
        	String userName = user!=null && StringUtils.isNotBlank(user.getUserName()) ? user.getUserName() : StringUtils.EMPTY;
        	list.add(AmountSpendRecordVo.build(record, customer.getName(), product.getName(), userName));
        });
        return new Pager(list, page.getTotalElements());
    }

    /**
     * 余额充值记录列表页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/amountSpendRecord/list")
    public String list(final Model model){
        return "amountSpendRecord/list";
    }

   /**
     * 新增页面
     * @return
     */
    @RequestMapping(value = "/amountSpendRecord/add")
    public String add(final Model model){
    	model.addAttribute("customers", customerService.findAll());
        model.addAttribute("products", productInformationService.findAll());
        return "amountSpendRecord/edit";
    }

    /**
     * 编辑页面
     * @param id
     * @return
     */
    //@RequestMapping(value = "/amountSpendRecord/edit")
    public String edit(final String id,final Model model){
        Optional.ofNullable(amountSpendRecordService.findOne(id)).ifPresent(amountSpendRecord -> model.addAttribute("bean",amountSpendRecord));
        return "amountSpendRecord/edit";
    }
}
