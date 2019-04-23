package com.zq.vm.controller;

import java.util.ArrayList;
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

import com.zq.vm.entity.ProductInformation;
import com.zq.vm.entity.ProductStock;
import com.zq.vm.entity.ResultJson;
import com.zq.vm.entity.vo.ProductStockVo;
import com.zq.vm.service.ProductInformationService;
import com.zq.vm.service.ProductStockService;
import com.zq.vm.utils.Pager;

/**
 * 描述: 商品库存控制器 
 * Time: 2019-04-13 14:48:40
 * @author: zou.qian
 * @version 1.0
 */
@Controller
public class ProductStockController {

    @Autowired
    private ProductStockService productStockService;
    @Autowired
    private ProductInformationService productInformationService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/productStock/{id}",method = RequestMethod.GET)
    public ProductStock productStock(@PathVariable(value = "id") String id){
        return productStockService.findOne(id);
    }


    /**
     * 保存
     * @param productStock
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/productStock",method = RequestMethod.POST)
    public ResultJson save(ProductStock productStock){
    	ProductInformation production = productInformationService.findOne(productStock.getProductId());
    	if(productStock.getType() == -1) {
    		List<ProductStock> list = productStockService.findByProductId(productStock.getProductId());
        	Integer stock = list.stream().mapToInt(ProductStock::getProductStockNumber).sum();
    		//检测当前库存数量是否大于出库数量
    		if(stock < productStock.getProductStockNumber()) {
    			return new ResultJson(ResultJson.ERROR,"操作失败，出库数量不能大于当前库存数量！");
    		}
    		productStock.setProductStockNumber(-productStock.getProductStockNumber());
    	}
    	productStock.setCreateTime(new Date());
        ProductStock save = productStockService.save(productStock);
        if(productStock.getType() == -1) {
        	//商品增加数量
        	production.addQuantity(-save.getProductStockNumber());
            productInformationService.save(production);
        }
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param productStock
     * @return
     */
    //@ResponseBody
    //@RequestMapping(value = "/productStock",method = RequestMethod.PUT)
    public ResultJson update(ProductStock productStock){
        productStockService.save(productStock);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/productStock/{id}",method = RequestMethod.DELETE)
    public ResultJson delete(@PathVariable(value = "id") String id){
        productStockService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param productStock
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/productStock/page",method = RequestMethod.POST)
    public Pager page(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, ProductStock productStock){
        Page<ProductStock> page = productStockService.findPageByCriteria(pageNumber, pageSize, productStock);
        return new Pager(page.getContent(), page.getTotalElements());
    }
    
    @ResponseBody
    @RequestMapping(value = "/productStock/productPage",method = RequestMethod.POST)
    public Pager productPage(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, String name){
        Page<ProductStock> page = productStockService.findPageByProductName(pageNumber, pageSize, name);
        List<ProductStockVo> list = new ArrayList<>(page.getSize());
        page.forEach(productStock -> {
        	ProductInformation product = productInformationService.findOne(productStock.getProductId());
        	list.add(ProductStockVo.build(productStock, product.getName()));
        });
        return new Pager(list, page.getTotalElements());
    }

    /**
     * 商品库存列表页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/productStock/list")
    public String list(final Model model){
        return "productStock/list";
    }

   /**
     * 新增页面
     * @return
     */
    @RequestMapping(value = "/productStock/add")
    public String add(final Model model,@RequestParam(value = "flag")Integer flag){
    	String title = flag == 1?"入库":"出库";
    	model.addAttribute("title", title);
    	model.addAttribute("flag", flag);
    	List<ProductInformation> products = productInformationService.findAll();
    	model.addAttribute("products", products);
        return "productStock/edit";
    }

    /**
     * 编辑页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/productStock/edit")
    public String edit(final String id,final Model model){
        Optional.ofNullable(productStockService.findOne(id)).ifPresent(productStock -> model.addAttribute("bean",productStock));
        return "productStock/edit";
    }
}
