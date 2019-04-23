package com.zq.vm.controller;

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
import com.zq.vm.entity.SetMealInformation;
import com.zq.vm.entity.vo.SetMealInformationProductVo;
import com.zq.vm.entity.vo.SetMealInformationVo;
import com.zq.vm.service.SetMealInformationProductService;
import com.zq.vm.service.SetMealInformationService;

/**
 * 描述: 套餐管理控制器 
 * Time: 2019-03-25 22:25:50
 * @author: zou.qian
 * @version 1.0
 */
@Controller
public class SetMealInformationController {

    @Autowired
    private SetMealInformationService setMealInformationService;
    @Autowired
    private SetMealInformationProductService setMealInformationProductService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/setMealInformation/{id}",method = RequestMethod.GET)
    public SetMealInformation setMealInformation(@PathVariable(value = "id") String id){
        return setMealInformationService.findOne(id);
    }


    /**
     * 保存
     * @param setMealInformation
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/setMealInformation",method = RequestMethod.POST)
    public ResultJson save(SetMealInformation setMealInformation){
        setMealInformationService.save(setMealInformation);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param setMealInformation
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/setMealInformation",method = RequestMethod.PUT)
    public ResultJson update(SetMealInformation setMealInformation){
        setMealInformationService.save(setMealInformation);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/setMealInformation/{id}",method = RequestMethod.DELETE)
    public ResultJson delete(@PathVariable(value = "id") String id){
        setMealInformationService.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param setMealInformation
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/setMealInformation/page",method = RequestMethod.POST)
    public Pager page(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, SetMealInformation setMealInformation){
        Page<SetMealInformation> page = setMealInformationService.findPageByCriteria(pageNumber, pageSize, setMealInformation);
        return new Pager(page.getContent(), page.getTotalElements());
    }

    /**
     * 套餐管理列表页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/setMealInformation/list")
    public String list(final Model model){
        return "setMealInformation/list";
    }

   /**
     * 新增页面
     * @return
     */
    @RequestMapping(value = "/setMealInformation/add")
    public String add(final Model model){
        return "setMealInformation/edit";
    }

    /**
     * 编辑页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/setMealInformation/edit")
    public String edit(final String id,final Model model){
        Optional.ofNullable(setMealInformationService.findOne(id)).ifPresent(setMealInformation -> model.addAttribute("bean",setMealInformation));
        return "setMealInformation/edit";
    }
    
    /**
     * 组合商品页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/setMealInformation/combination/{id}")
    public String combination(@PathVariable(value = "id")final String id,final Model model) {
    	model.addAttribute("id", id);
    	return "setMealInformation/combination";
    }
    
    /**
     * 商品组合保存
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/setMealInformation/combination", method = RequestMethod.POST)
    public ResultJson combination(final SetMealInformationVo vo) {
    	try {
			setMealInformationService.saveProduct(vo);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultJson(ResultJson.ERROR, "操作失败，系统异常");
		}
    	return new ResultJson(ResultJson.SUCCESS, "操作成功");
    }
    
    /**
     * 根据套餐id查询选择的商品
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/setMealInformation/combinations", method = RequestMethod.GET)
    public List<SetMealInformationProductVo> combinations(@RequestParam(required = true,value = "id")final String id){
    	return setMealInformationProductService.findVoBySetMealInforamtionId(id);
    }
}
