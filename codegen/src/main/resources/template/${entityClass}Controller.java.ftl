package ${package}.controller;

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
import ${package}.entity.${entityClass};
import ${package}.service.${entityClass}Service;
import com.zq.vm.utils.Pager;

/**
 * 描述: ${logicName}控制器 
 * Time: <#if time??>${time}</#if>
 * @author: <#if author??>${author}</#if>
 * @version 1.0
 */
@Controller
public class ${entityClass}Controller {

    @Autowired
    private ${entityClass}Service ${simpleName}Service;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/${simpleName}/{id}",method = RequestMethod.GET)
    public ${entityClass} ${simpleName}(@PathVariable(value = "id") String id){
        return ${simpleName}Service.findOne(id);
    }


    /**
     * 保存
     * @param ${simpleName}
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/${simpleName}",method = RequestMethod.POST)
    public ResultJson save(${entityClass} ${simpleName}){
        ${simpleName}Service.save(${simpleName});
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 更新
     * @param ${simpleName}
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/${simpleName}",method = RequestMethod.PUT)
    public ResultJson update(${entityClass} ${simpleName}){
        ${simpleName}Service.save(${simpleName});
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/${simpleName}/{id}",method = RequestMethod.DELETE)
    public ResultJson delete(@PathVariable(value = "id") String id){
        ${simpleName}Service.delete(id);
        return new ResultJson(ResultJson.SUCCESS,"操作成功！");
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param ${simpleName}
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/${simpleName}/page",method = RequestMethod.POST)
    public Pager page(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, ${entityClass} ${simpleName}){
        Page<${entityClass}> page = ${simpleName}Service.findPageByCriteria(pageNumber, pageSize, ${simpleName});
        return new Pager(page.getContent(), page.getTotalElements());
    }

    /**
     * ${logicName}列表页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/${simpleName}/list")
    public String list(final Model model){
        return "/${simpleName}/list";
    }

   /**
     * 新增页面
     * @return
     */
    @RequestMapping(value = "/${simpleName}/add")
    public String add(final Model model){
        return "/${simpleName}/edit";
    }

    /**
     * 编辑页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/${simpleName}/edit")
    public String edit(final String id,final Model model){
        Optional.ofNullable(${simpleName}Service.findOne(id)).ifPresent(${simpleName} -> model.addAttribute("bean",${simpleName}));
        return "/${simpleName}/edit";
    }
}
