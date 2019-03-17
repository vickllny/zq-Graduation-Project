package com.zq.vm.controller;

import com.zq.vm.entity.ResultJson;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.SetMealInformation;
import com.zq.vm.service.SetMealInformationService;

/**
 * 描述: 余额信息控制器 
 * Time: 2019-02-24 19:05:19
 * @author: zou.qian
 * @version 1.0
 */
@Controller
@RequestMapping(value = "setMealInformation")
public class SetMealInformationController {

   @Autowired
    private SetMealInformationService setMealInformationService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public SetMealInformation setMealInformation(@PathVariable(value = "id") String id){
        return setMealInformationService.findOne(id);
    }


    /**
     * 保存
     * @param setMealInformation
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResultJson save(SetMealInformation setMealInformation){
        setMealInformationService.save(setMealInformation);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param setMealInformation
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public ResultJson update(SetMealInformation setMealInformation){
        setMealInformationService.save(setMealInformation);
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
        setMealInformationService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param setMealInformation
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/page/{pageNumber}/{pageSize}",method = RequestMethod.POST)
    public ResultJson page(@PathVariable(value = "pageNumber") Integer pageNumber,@PathVariable(value = "pageSize") Integer pageSize,SetMealInformation setMealInformation){
        Page<SetMealInformation> page = setMealInformationService.findPageByCriteria(pageNumber, pageSize, setMealInformation);
    	return new ResultJson(ResultJson.SUCCESS,"操作成功！", page);
    }

}
