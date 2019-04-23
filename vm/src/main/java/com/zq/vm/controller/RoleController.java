package com.zq.vm.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.zq.vm.utils.Pager;
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
import com.zq.vm.entity.Role;
import com.zq.vm.entity.ZTree;
import com.zq.vm.service.RoleMenuService;
import com.zq.vm.service.RoleService;

/**
 * 描述: 角色控制器 
 * Time: 2019-03-22 22:05:20
 * @author: zou.qian
 * @version 1.0
 */
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleMenuService roleMenuService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/role/{id}",method = RequestMethod.GET)
    public Role role(@PathVariable(value = "id") String id){
        return roleService.findOne(id);
    }


    /**
     * 保存
     * @param role
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/role",method = RequestMethod.POST)
    public ResultJson save(Role role){
        role.setCreateTime(new Date());
        roleService.save(role);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param role
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/role",method = RequestMethod.PUT)
    public ResultJson update(Role role){
        roleService.save(role);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/role/{id}",method = RequestMethod.DELETE)
    public ResultJson delete(@PathVariable(value = "id") String id){
        roleService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param role
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/role/page",method = RequestMethod.POST)
    public Pager page(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, Role role){
        Page<Role> page = roleService.findPageByCriteria(pageNumber, pageSize, role);
        return new Pager(page.getContent(), page.getTotalElements());
    }

    /**
     * 角色列表页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/role/list")
    public String list(final Model model){
        return "role/list";
    }

   /**
     * 新增页面
     * @return
     */
    @RequestMapping(value = "/role/add")
    public String add(final Model model){
        return "role/edit";
    }

    /**
     * 编辑页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/role/edit")
    public String edit(final String id,final Model model){
        Optional.ofNullable(roleService.findOne(id)).ifPresent(role -> model.addAttribute("bean",role));
        return "role/edit";
    }
    
    @RequestMapping(value = "/role/permission", method = RequestMethod.GET)
    public String permission(final String roleId,final Model model) {
    	model.addAttribute("roleId", roleId);
    	return "role/permission";
    }
    
    @ResponseBody
    @RequestMapping(value = "/role/permission", method = RequestMethod.POST)
    public List<ZTree> permission(@RequestParam(value = "roleId",required = true)String roleId){
    	return roleService.permission(roleId);
    }
    
    @ResponseBody
    @RequestMapping(value = "/role/savePermission", method = RequestMethod.POST)
    public ResultJson savePermission(@RequestParam(value = "roleId",required = true)String roleId,@RequestParam(value = "menuIds[]") String[] menuIds){
    	roleMenuService.save(roleId,menuIds);
    	return new ResultJson(ResultJson.SUCCESS, "保存成功");
    }
}
