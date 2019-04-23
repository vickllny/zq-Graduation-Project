package com.zq.vm.controller;

import java.util.Date;
import java.util.List;
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
import com.zq.vm.entity.SysCode;
import com.zq.vm.entity.SysCodeItem;
import com.zq.vm.entity.vo.SysCodeItemVo;
import com.zq.vm.service.SysCodeItemService;
import com.zq.vm.service.SysCodeService;
import com.zq.vm.utils.Pager;

/**
 * 描述: 系统code控制器 
 * Time: 2019-04-14 14:23:49
 * @author: zou.qian
 * @version 1.0
 */
@Controller
public class SysCodeController {

    @Autowired
    private SysCodeService sysCodeService;
    @Autowired
    private SysCodeItemService sysCodeItemService;
    
    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sysCode/{id}",method = RequestMethod.GET)
    public SysCode sysCode(@PathVariable(value = "id") String id){
        return sysCodeService.findOne(id);
    }


    /**
     * 保存
     * @param sysCode
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sysCode",method = RequestMethod.POST)
    public ResultJson save(SysCode sysCode){
    	//查询是否已经存在此code
    	SysCode sysCode1 = sysCodeService.findByCode(sysCode.getCode());
    	if(sysCode1 != null) {
    		return new ResultJson(ResultJson.ERROR, "操作失败，"+sysCode.getCode()+"已经存在");
    	}
    	
    	sysCode.setCreateTime(new Date());
        sysCodeService.save(sysCode);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param sysCode
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sysCode",method = RequestMethod.PUT)
    public ResultJson update(SysCode sysCode){
    	//判断名称是否已经修改
    	SysCode oldSysCode = sysCodeService.findOne(sysCode.getId());
    	if(!oldSysCode.getName().equals(sysCode.getName())) {
    		//判断是否已经存在此名称
    		SysCode oldSysCode1 = sysCodeService.findByNameAndIdNot(sysCode.getName(), sysCode.getId());
    		if(oldSysCode1 != null) {
    			return new ResultJson(ResultJson.ERROR,"操作失败，已经存在名称为 "+sysCode.getName()+" 的code");
    		}
    	}
    	//判断code
    	if(!oldSysCode.getCode().equals(sysCode.getCode())) {
    		//判断是否已经存在此code
    		SysCode oldSysCode1 = sysCodeService.findByCodeAndIdNot(sysCode.getCode(), sysCode.getId());
    		if(oldSysCode1 != null) {
    			return new ResultJson(ResultJson.ERROR,"操作失败，已经存在code为 "+sysCode.getCode()+" 的code");
    		}
    	}
    	
        sysCodeService.save(sysCode);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sysCode/{id}",method = RequestMethod.DELETE)
    public ResultJson delete(@PathVariable(value = "id") String id){
        sysCodeService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param sysCode
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sysCode/page",method = RequestMethod.POST)
    public Pager page(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, SysCode sysCode){
        Page<SysCode> page = sysCodeService.findPageByCriteria(pageNumber, pageSize, sysCode);
        return new Pager(page.getContent(), page.getTotalElements());
    }

    /**
     * 系统code列表页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/sysCode/list")
    public String list(final Model model){
        return "sysCode/list";
    }

   /**
     * 新增页面
     * @return
     */
    @RequestMapping(value = "/sysCode/add")
    public String add(final Model model){
        return "sysCode/edit";
    }

    /**
     * 编辑页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/sysCode/edit")
    public String edit(final String id,final Model model){
        Optional.ofNullable(sysCodeService.findOne(id)).ifPresent(sysCode -> model.addAttribute("bean",sysCode));
        return "sysCode/edit";
    }
    
    /**
     * 管理编码值
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value  = "/sysCode/manageCodeItem/{id}")
    public String manageCodeItem(@PathVariable("id")final String id,final Model model) {
    	model.addAttribute("id",id);
    	Optional.ofNullable(sysCodeService.findOne(id)).ifPresent(sysCode -> model.addAttribute("bean",sysCode));
    	return "sysCode/manageCodeItem";
    }
    
    /**
     * 根据codeId查询codeItem
     * @param codeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sysCode/codeItems/{codeId}")
    public List<SysCodeItem> codeItems(@PathVariable(value = "codeId")final String codeId){
    	return sysCodeItemService.findBySysCodeId(codeId);
    }
    
    /**
     * 保存编码值
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sysCode/saveCodeItem",method = RequestMethod.POST)
    public ResultJson saveCodeItem(final SysCodeItemVo vo){
    	sysCodeItemService.save(vo);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }
}
