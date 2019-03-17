package com.zq.vm.controller;

import com.zq.vm.entity.ResultJson;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.SetMealInformationProduct;
import com.zq.vm.service.SetMealInformationProductService;

/**
 * 描述: 余额信息控制器 
 * Time: 2019-02-24 19:07:37
 * @author: zou.qian
 * @version 1.0
 */
@Controller
@RequestMapping(value = "setMealInformationProduct")
public class SetMealInformationProductController {

   @Autowired
    private SetMealInformationProductService setMealInformationProductService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public SetMealInformationProduct setMealInformationProduct(@PathVariable(value = "id") String id){
        return setMealInformationProductService.findOne(id);
    }


    /**
     * 保存
     * @param setMealInformationProduct
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResultJson save(SetMealInformationProduct setMealInformationProduct){
        setMealInformationProductService.save(setMealInformationProduct);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param setMealInformationProduct
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public ResultJson update(SetMealInformationProduct setMealInformationProduct){
        setMealInformationProductService.save(setMealInformationProduct);
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
        setMealInformationProductService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param setMealInformationProduct
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/page/{pageNumber}/{pageSize}",method = RequestMethod.POST)
    public ResultJson page(@PathVariable(value = "pageNumber") Integer pageNumber,@PathVariable(value = "pageSize") Integer pageSize,SetMealInformationProduct setMealInformationProduct){
        Page<SetMealInformationProduct> page = setMealInformationProductService.findPageByCriteria(pageNumber, pageSize, setMealInformationProduct);
    	return new ResultJson(ResultJson.SUCCESS,"操作成功！", page);
    }

}
