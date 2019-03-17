package com.zq.vm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

    @RequestMapping(value = {"/","index"})
    public String index(){
        return "index";
    }
}
