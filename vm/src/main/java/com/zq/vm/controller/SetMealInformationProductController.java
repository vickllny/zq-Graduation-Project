package com.zq.vm.controller;

import java.util.Optional;

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
import com.zq.vm.entity.SetMealInformationProduct;
import com.zq.vm.service.SetMealInformationProductService;
import com.zq.vm.utils.Pager;

/**
 * 描述: 套餐商品信息表控制器 
 * Time: 2019-04-21 17:12:30
 * @author: zou.qian
 * @version 1.0
 */
@Controller
public class SetMealInformationProductController {

    @Autowired
    private SetMealInformationProductService setMealInformationProductService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/setMealInformationProduct/{id}",method = RequestMethod.GET)
    public SetMealInformationProduct setMealInformationProduct(@PathVariable(value = "id") String id){
        return setMealInformationProductService.findOne(id);
    }


    /**
     * 保存
     * @param setMealInformationProduct
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/setMealInformationProduct",method = RequestMethod.POST)
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
    @RequestMapping(value = "/setMealInformationProduct",method = RequestMethod.PUT)
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
    @RequestMapping(value = "/setMealInformationProduct/{id}",method = RequestMethod.DELETE)
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
    @RequestMapping(value = "/setMealInformationProduct/page",method = RequestMethod.POST)
    public Pager page(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, SetMealInformationProduct setMealInformationProduct){
        Page<SetMealInformationProduct> page = setMealInformationProductService.findPageByCriteria(pageNumber, pageSize, setMealInformationProduct);
        return new Pager(page.getContent(), page.getTotalElements());
    }

    /**
     * 套餐商品信息表列表页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/setMealInformationProduct/list")
    public String list(final Model model){
        return "setMealInformationProduct/list";
    }

   /**
     * 新增页面
     * @return
     */
    @RequestMapping(value = "/setMealInformationProduct/add")
    public String add(final Model model){
        return "setMealInformationProduct/edit";
    }

    /**
     * 编辑页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/setMealInformationProduct/edit")
    public String edit(final String id,final Model model){
        Optional.ofNullable(setMealInformationProductService.findOne(id)).ifPresent(setMealInformationProduct -> model.addAttribute("bean",setMealInformationProduct));
        return "setMealInformationProduct/edit";
    }
}
