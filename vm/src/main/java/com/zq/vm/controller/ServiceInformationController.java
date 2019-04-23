package com.zq.vm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.collections.MapUtils;
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
import com.zq.vm.entity.ServiceInformation;
import com.zq.vm.entity.SysCodeItem;
import com.zq.vm.entity.vo.ServiceInformationVo;
import com.zq.vm.service.ServiceInformationService;
import com.zq.vm.service.SysCodeItemService;
import com.zq.vm.utils.Pager;

/**
 * 描述: 服务信息表(商品)控制器 
 * Time: 2019-04-16 23:18:35
 * @author: zou.qian
 * @version 1.0
 */
@Controller
public class ServiceInformationController {

    @Autowired
    private ServiceInformationService serviceInformationService;
    @Autowired
    private SysCodeItemService sysCodeItemService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/serviceInformation/{id}",method = RequestMethod.GET)
    public ServiceInformation serviceInformation(@PathVariable(value = "id") String id){
        return serviceInformationService.findOne(id);
    }


    /**
     * 保存
     * @param serviceInformation
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/serviceInformation",method = RequestMethod.POST)
    public ResultJson save(ServiceInformation serviceInformation){
    	serviceInformation.setCreateTime(new Date());
        serviceInformationService.save(serviceInformation);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param serviceInformation
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/serviceInformation",method = RequestMethod.PUT)
    public ResultJson update(ServiceInformation serviceInformation){
        serviceInformationService.save(serviceInformation);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/serviceInformation/{id}",method = RequestMethod.DELETE)
    public ResultJson delete(@PathVariable(value = "id") String id){
        serviceInformationService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param serviceInformation
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/serviceInformation/page",method = RequestMethod.POST)
    public Pager page(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, ServiceInformation serviceInformation){
        Page<ServiceInformation> page = serviceInformationService.findPageByCriteria(pageNumber, pageSize, serviceInformation);
        List<ServiceInformationVo> vo = new ArrayList<>(page.getNumberOfElements());
        Map<String, String> codeMap = sysCodeItemService.findMapBySysCode("service_category");
        page.forEach(bean -> {
        	String name = MapUtils.getString(codeMap, bean.getType(), "");
        	vo.add(ServiceInformationVo.build(bean, name));
        });
        return new Pager(vo, page.getTotalElements());
    }

    /**
     * 服务信息表(商品)列表页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/serviceInformation/list")
    public String list(final Model model){
        return "serviceInformation/list";
    }

   /**
     * 新增页面
     * @return
     */
    @RequestMapping(value = "/serviceInformation/add")
    public String add(final Model model){
    	List<SysCodeItem> list = sysCodeItemService.findBySysCode("service_category");
    	model.addAttribute("list", list);
        return "serviceInformation/edit";
    }

    /**
     * 编辑页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/serviceInformation/edit")
    public String edit(final String id,final Model model){
        Optional.ofNullable(serviceInformationService.findOne(id)).ifPresent(serviceInformation -> model.addAttribute("bean",serviceInformation));
        List<SysCodeItem> list = sysCodeItemService.findBySysCode("service_category");
    	model.addAttribute("list", list);
        return "serviceInformation/edit";
    }
}
