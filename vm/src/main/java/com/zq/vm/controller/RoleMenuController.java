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
import com.zq.vm.entity.RoleMenu;
import com.zq.vm.service.RoleMenuService;
import com.zq.vm.utils.Pager;

/**
 * 描述: 角色菜单控制器 
 * Time: 2019-04-10 20:54:16
 * @author: zou.qian
 * @version 1.0
 */
@Controller
public class RoleMenuController {

    @Autowired
    private RoleMenuService roleMenuService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/roleMenu/{id}",method = RequestMethod.GET)
    public RoleMenu roleMenu(@PathVariable(value = "id") String id){
        return roleMenuService.findOne(id);
    }


    /**
     * 保存
     * @param roleMenu
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/roleMenu",method = RequestMethod.POST)
    public ResultJson save(RoleMenu roleMenu){
        roleMenuService.save(roleMenu);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param roleMenu
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/roleMenu",method = RequestMethod.PUT)
    public ResultJson update(RoleMenu roleMenu){
        roleMenuService.save(roleMenu);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/roleMenu/{id}",method = RequestMethod.DELETE)
    public ResultJson delete(@PathVariable(value = "id") String id){
        roleMenuService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param roleMenu
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/roleMenu/page",method = RequestMethod.POST)
    public Pager page(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, RoleMenu roleMenu){
        Page<RoleMenu> page = roleMenuService.findPageByCriteria(pageNumber, pageSize, roleMenu);
        return new Pager(page.getContent(), page.getTotalElements());
    }

    /**
     * 角色菜单列表页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/roleMenu/list")
    public String list(final Model model){
        return "roleMenu/list";
    }

   /**
     * 新增页面
     * @return
     */
    @RequestMapping(value = "/roleMenu/add")
    public String add(final Model model){
        return "roleMenu/edit";
    }

    /**
     * 编辑页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/roleMenu/edit")
    public String edit(final String id,final Model model){
        Optional.ofNullable(roleMenuService.findOne(id)).ifPresent(roleMenu -> model.addAttribute("bean",roleMenu));
        return "roleMenu/edit";
    }
}
