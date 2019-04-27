package com.zq.vm.controller;

import java.util.ArrayList;
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
import com.zq.vm.entity.vo.ProductInformationVo;
import com.zq.vm.entity.ProductInformation;
import com.zq.vm.service.ProductInformationService;
import com.zq.vm.utils.Pager;

/**
 * 描述: 商品信息控制器 
 * Time: 2019-04-13 14:55:42
 * @author: zou.qian
 * @version 1.0
 */
@Controller
public class ProductInformationController {

    @Autowired
    private ProductInformationService productInformationService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/productInformation/{id}",method = RequestMethod.GET)
    public ProductInformation productInformation(@PathVariable(value = "id") String id){
        return productInformationService.findOne(id);
    }


    /**
     * 保存
     * @param productInformation
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/productInformation",method = RequestMethod.POST)
    public ResultJson save(ProductInformation productInformation){
        productInformationService.save(productInformation);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param productInformation
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/productInformation",method = RequestMethod.PUT)
    public ResultJson update(ProductInformation productInformation){
        productInformationService.save(productInformation);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/productInformation/{id}",method = RequestMethod.DELETE)
    public ResultJson delete(@PathVariable(value = "id") String id){
        productInformationService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param productInformation
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/productInformation/page",method = RequestMethod.POST)
    public Pager page(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, ProductInformation productInformation){
        Page<ProductInformation> page = productInformationService.findPageByCriteria(pageNumber, pageSize, productInformation);
        return new Pager(page.getContent(), page.getTotalElements());
    }

    /**
     * 商品信息列表页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/productInformation/list")
    public String list(final Model model){
        return "productInformation/list";
    }

   /**
     * 新增页面
     * @return
     */
    @RequestMapping(value = "/productInformation/add")
    public String add(final Model model){
        return "productInformation/edit";
    }

    /**
     * 编辑页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/productInformation/edit")
    public String edit(final String id,final Model model){
        Optional.ofNullable(productInformationService.findOne(id)).ifPresent(productInformation -> model.addAttribute("bean",productInformation));
        return "productInformation/edit";
    }
    
    /**
     * 统计页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/productInformation/statistics")
    public String statistics(final Model model){
        return "productInformation/statisticsList";
    }
    
    /**
     * 商品业务排行
     * @param model
     * @return
     */
    @RequestMapping(value = "/productInformation/businessRank")
    public String businessRank(final Model model){
        return "productInformation/businessRank";
    }
    
    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param productInformation
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/productInformation/rankPage",method = RequestMethod.POST)
    public Pager rankPage(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, String name){
        Page<Object[]> page = productInformationService.findRankPage(pageNumber, pageSize, name);
        List<ProductInformationVo> vo = new ArrayList<>(page.getNumberOfElements());
        page.forEach(array -> vo.add(ProductInformationVo.build(array)));
        return new Pager(vo, page.getTotalElements());
    }
}
