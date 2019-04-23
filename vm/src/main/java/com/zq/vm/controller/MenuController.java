package com.zq.vm.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zq.vm.entity.Menu;
import com.zq.vm.entity.ResultJson;
import com.zq.vm.entity.ZTree;
import com.zq.vm.service.MenuService;
import com.zq.vm.utils.Pager;

/**
 * 描述: 菜单控制器 
 * Time: 2019-03-03 21:20:03
 * @author: zou.qian
 * @version 1.0
 */
@Controller
public class MenuController {

	@Autowired
    private MenuService menuService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/menu/{id}",method = RequestMethod.GET)
    public Menu menu(@PathVariable(value = "id") String id){
        return menuService.findOne(id);
    }

    /**
     * 查询所有
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/menu",method = RequestMethod.GET)
    public List<Menu> menu(){
        return menuService.findAll();
    }

    /**
     * 保存
     * @param menu
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/menu",method = RequestMethod.POST)
    public ResultJson save(Menu menu){
        if(StringUtils.isBlank(menu.getPid())){
            menu.setPid("#");
        }
        menuService.save(menu);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param menu
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/menu",method = RequestMethod.PUT)
    public ResultJson update(Menu menu){
        menuService.save(menu);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/menu/{id}",method = RequestMethod.DELETE)
    public ResultJson delete(@PathVariable(value = "id") String id){
    	if(CollectionUtils.isNotEmpty(menuService.findByPid(id))){
    		return new ResultJson(ResultJson.ERROR, "操作失败，请先删除子菜单");
    	}
        menuService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param menu
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/menu/page",method = RequestMethod.POST)
    public Pager page(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, Menu menu){
        Page<Menu> page = menuService.findPageByCriteria(pageNumber, pageSize, menu);
    	return new Pager(page.getContent(), page.getTotalElements());
    }

    /**
     * 菜单列表页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/menu/list")
    public String list(final Model model){
        return "menu/list";
    }

    /**
     * 树json数据
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/menu/treeData")
    public List<ZTree> treeData(){
        return menuService.treeData();
    }

    /**
     * 新增菜单
     * @return
     */
    @RequestMapping(value = "/menu/add")
    public String add(final String pid,final Model model){
    	Optional.ofNullable(pid).ifPresent(var1 -> {
    		Menu menu = new Menu();
    		menu.setPid(var1);
    		model.addAttribute("bean", menu);
    	});
        return "menu/edit";
    }

    /**
     * 编辑
     * @param id
     * @return
     */
    @RequestMapping(value = "/menu/edit")
    public String edit(final String id,final Model model){
        Optional.ofNullable(menuService.findOne(id)).ifPresent(menu -> model.addAttribute("bean",menu));
        return "menu/edit";
    }
    
    /**
     * 用户菜单
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/menu/userMenu")
    public List<Menu> userMenu(HttpSession session) {
    	String userId = String.valueOf(session.getAttribute("userId"));
    	return menuService.findMenuByUserId(userId);
    }
}
