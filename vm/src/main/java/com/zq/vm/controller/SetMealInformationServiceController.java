package com.zq.vm.controller;

import com.zq.vm.entity.ResultJson;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.SetMealInformationService;
import com.zq.vm.service.SetMealInformationServiceService;

/**
 * 描述: 余额信息控制器 
 * Time: 2019-02-24 19:09:31
 * @author: zou.qian
 * @version 1.0
 */
@Controller
@RequestMapping(value = "setMealInformationService")
public class SetMealInformationServiceController {

   @Autowired
    private SetMealInformationServiceService setMealInformationServiceService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public SetMealInformationService setMealInformationService(@PathVariable(value = "id") String id){
        return setMealInformationServiceService.findOne(id);
    }


    /**
     * 保存
     * @param setMealInformationService
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResultJson save(SetMealInformationService setMealInformationService){
        setMealInformationServiceService.save(setMealInformationService);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param setMealInformationService
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public ResultJson update(SetMealInformationService setMealInformationService){
        setMealInformationServiceService.save(setMealInformationService);
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
        setMealInformationServiceService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param setMealInformationService
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/page/{pageNumber}/{pageSize}",method = RequestMethod.POST)
    public ResultJson page(@PathVariable(value = "pageNumber") Integer pageNumber,@PathVariable(value = "pageSize") Integer pageSize,SetMealInformationService setMealInformationService){
        Page<SetMealInformationService> page = setMealInformationServiceService.findPageByCriteria(pageNumber, pageSize, setMealInformationService);
    	return new ResultJson(ResultJson.SUCCESS,"操作成功！", page);
    }

}
