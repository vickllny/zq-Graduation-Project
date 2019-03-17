package com.zq.vm.controller;

import com.zq.vm.entity.ResultJson;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.AmountRechargeRecord;
import com.zq.vm.service.AmountRechargeRecordService;

/**
 * 描述: 余额信息控制器 
 * Time: 2019-02-24 18:31:50
 * @author: zou.qian
 * @version 1.0
 */
@Controller
@RequestMapping(value = "amountRechargeRecord")
public class AmountRechargeRecordController {

   @Autowired
    private AmountRechargeRecordService amountRechargeRecordService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public AmountRechargeRecord amountRechargeRecord(@PathVariable(value = "id") String id){
        return amountRechargeRecordService.findOne(id);
    }


    /**
     * 保存
     * @param amountRechargeRecord
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResultJson save(AmountRechargeRecord amountRechargeRecord){
        amountRechargeRecordService.save(amountRechargeRecord);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param amountRechargeRecord
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public ResultJson update(AmountRechargeRecord amountRechargeRecord){
        amountRechargeRecordService.save(amountRechargeRecord);
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
    @RequestMapping(value = "/page/{pageNumber}/{pageSize}",method = RequestMethod.POST)
    public ResultJson page(@PathVariable(value = "pageNumber") Integer pageNumber,@PathVariable(value = "pageSize") Integer pageSize,AmountRechargeRecord amountRechargeRecord){
        Page<AmountRechargeRecord> page = amountRechargeRecordService.findPageByCriteria(pageNumber, pageSize, amountRechargeRecord);
    	return new ResultJson(ResultJson.SUCCESS,"操作成功！", page);
    }

}
