package com.zq.vm.controller;

import com.zq.vm.entity.ResultJson;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.ServiceInformation;
import com.zq.vm.service.ServiceInformationService;

/**
 * 描述: 余额信息控制器 
 * Time: 2019-02-24 19:02:59
 * @author: zou.qian
 * @version 1.0
 */
@Controller
@RequestMapping(value = "serviceInformation")
public class ServiceInformationController {

   @Autowired
    private ServiceInformationService serviceInformationService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ServiceInformation serviceInformation(@PathVariable(value = "id") String id){
        return serviceInformationService.findOne(id);
    }


    /**
     * 保存
     * @param serviceInformation
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResultJson save(ServiceInformation serviceInformation){
        serviceInformationService.save(serviceInformation);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param serviceInformation
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public ResultJson update(ServiceInformation serviceInformation){
        serviceInformationService.save(serviceInformation);
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
        serviceInformationService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param serviceInformation
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/page/{pageNumber}/{pageSize}",method = RequestMethod.POST)
    public ResultJson page(@PathVariable(value = "pageNumber") Integer pageNumber,@PathVariable(value = "pageSize") Integer pageSize,ServiceInformation serviceInformation){
        Page<ServiceInformation> page = serviceInformationService.findPageByCriteria(pageNumber, pageSize, serviceInformation);
    	return new ResultJson(ResultJson.SUCCESS,"操作成功！", page);
    }

}
