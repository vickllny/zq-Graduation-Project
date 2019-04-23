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
import com.zq.vm.entity.SysCodeItem;
import com.zq.vm.service.SysCodeItemService;
import com.zq.vm.utils.Pager;

/**
 * 描述: 系统编码值控制器 
 * Time: 2019-04-14 16:00:27
 * @author: zou.qian
 * @version 1.0
 */
@Controller
public class SysCodeItemController {

    @Autowired
    private SysCodeItemService sysCodeItemService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sysCodeItem/{id}",method = RequestMethod.GET)
    public SysCodeItem sysCodeItem(@PathVariable(value = "id") String id){
        return sysCodeItemService.findOne(id);
    }


    /**
     * 保存
     * @param sysCodeItem
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sysCodeItem",method = RequestMethod.POST)
    public ResultJson save(SysCodeItem sysCodeItem){
        sysCodeItemService.save(sysCodeItem);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param sysCodeItem
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sysCodeItem",method = RequestMethod.PUT)
    public ResultJson update(SysCodeItem sysCodeItem){
        sysCodeItemService.save(sysCodeItem);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sysCodeItem/{id}",method = RequestMethod.DELETE)
    public ResultJson delete(@PathVariable(value = "id") String id){
        sysCodeItemService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param sysCodeItem
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sysCodeItem/page",method = RequestMethod.POST)
    public Pager page(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, SysCodeItem sysCodeItem){
        Page<SysCodeItem> page = sysCodeItemService.findPageByCriteria(pageNumber, pageSize, sysCodeItem);
        return new Pager(page.getContent(), page.getTotalElements());
    }

    /**
     * 系统编码值列表页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/sysCodeItem/list")
    public String list(final Model model){
        return "sysCodeItem/list";
    }

   /**
     * 新增页面
     * @return
     */
    @RequestMapping(value = "/sysCodeItem/add")
    public String add(final Model model){
        return "sysCodeItem/edit";
    }

    /**
     * 编辑页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/sysCodeItem/edit")
    public String edit(final String id,final Model model){
        Optional.ofNullable(sysCodeItemService.findOne(id)).ifPresent(sysCodeItem -> model.addAttribute("bean",sysCodeItem));
        return "sysCodeItem/edit";
    }
}
