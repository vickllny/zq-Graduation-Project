package com.zq.vm.controller;

import com.zq.vm.entity.ResultJson;
import com.zq.vm.entity.User;
import com.zq.vm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DashboardController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/","index"})
    public String index(){
        return "index";
    }

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "/login";
    }

    @ResponseBody
    @RequestMapping(value = "login",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultJson login(HttpServletRequest request, @RequestParam(value = "userName",required = true) String userName
            ,@RequestParam(value = "password",required = true) String password){
        User user = userService.findByUserName(userName);
        if (user == null){
            return new ResultJson(ResultJson.ERROR, "用户不存在");
        }
        if(!user.getPassword().equals(password)){
            return new ResultJson(ResultJson.ERROR, "密码错误");
        }
        request.getSession().setAttribute("userName", userName);
        return new ResultJson(ResultJson.SUCCESS, "登录成功");
    }
}
