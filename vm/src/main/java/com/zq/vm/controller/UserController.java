package com.zq.vm.controller;

import java.util.Date;
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
import com.zq.vm.entity.User;
import com.zq.vm.service.UserService;
import com.zq.vm.utils.Pager;

/**
 * 描述: 用户控制器 
 * Time: 2019-03-17 18:57:29
 * @author: zou.qian
 * @version 1.0
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public User user(@PathVariable(value = "id") String id){
        return userService.findOne(id);
    }


    /**
     * 保存
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public ResultJson save(User user){
    	user.setCreateTime(new Date());
        userService.save(user);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public ResultJson update(User user){
        userService.save(user);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public ResultJson delete(@PathVariable(value = "id") String id){
        userService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/page",method = RequestMethod.POST)
    public Pager page(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, User user){
        Page<User> page = userService.findPageByCriteria(pageNumber, pageSize, user);
        return new Pager(page.getContent(), page.getTotalElements());
    }

    /**
     * 用户列表页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/user/list")
    public String list(final Model model){
        return "/user/list";
    }

   /**
     * 新增页面
     * @return
     */
    @RequestMapping(value = "/user/add")
    public String add(final Model model){
        return "/user/edit";
    }

    /**
     * 编辑页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/edit")
    public String edit(final String id,final Model model){
        Optional.ofNullable(userService.findOne(id)).ifPresent(user -> model.addAttribute("bean",user));
        return "/user/edit";
    }
}
