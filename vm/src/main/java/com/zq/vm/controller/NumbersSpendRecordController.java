package com.zq.vm.controller;

import com.zq.vm.entity.ResultJson;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.NumbersSpendRecord;
import com.zq.vm.service.NumbersSpendRecordService;

/**
 * 描述: 余额信息控制器 
 * Time: 2019-02-24 18:51:14
 * @author: zou.qian
 * @version 1.0
 */
@Controller
@RequestMapping(value = "numbersSpendRecord")
public class NumbersSpendRecordController {

   @Autowired
    private NumbersSpendRecordService numbersSpendRecordService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public NumbersSpendRecord numbersSpendRecord(@PathVariable(value = "id") String id){
        return numbersSpendRecordService.findOne(id);
    }


    /**
     * 保存
     * @param numbersSpendRecord
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResultJson save(NumbersSpendRecord numbersSpendRecord){
        numbersSpendRecordService.save(numbersSpendRecord);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param numbersSpendRecord
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.PUT)
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
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
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
    @RequestMapping(value = "/page/{pageNumber}/{pageSize}",method = RequestMethod.POST)
    public ResultJson page(@PathVariable(value = "pageNumber") Integer pageNumber,@PathVariable(value = "pageSize") Integer pageSize,NumbersSpendRecord numbersSpendRecord){
        Page<NumbersSpendRecord> page = numbersSpendRecordService.findPageByCriteria(pageNumber, pageSize, numbersSpendRecord);
    	return new ResultJson(ResultJson.SUCCESS,"操作成功！", page);
    }

}
