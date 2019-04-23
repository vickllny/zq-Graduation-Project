package com.zq.vm.service;

import com.zq.vm.entity.SysCodeItem;
import com.zq.vm.entity.vo.SysCodeItemVo;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * 描述: 系统编码值业务接口
 * Time: 2019-04-14 16:00:27
 * @author: zou.qian
 * @version 1.0
 */
public interface SysCodeItemService{

    /**
     * 保存
     * @param sysCodeItem
     * @return
     */
	SysCodeItem save(SysCodeItem sysCodeItem);

    /**
     * 删除
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param sysCodeItem
     * @return
     */
    Page<SysCodeItem> findPageByCriteria(int pageNumber, int pageSize, SysCodeItem sysCodeItem);

    /**
    * 根据id查询
    * @param id
    * @return
    */
	SysCodeItem findOne(String id);

    /**
     * 查询所有
     * @return
     */
    List<SysCodeItem> findAll();

    /**
     * 根据codeId查询codeItem
     * @param codeId
     * @return
     */
	List<SysCodeItem> findBySysCodeId(String codeId);

    /**
     * 保存编码值
     * @param vo
     * @return
     */
	void save(SysCodeItemVo vo);

	/**
	 * 根据编码获取编码值
	 * @param string
	 * @return
	 */
	List<SysCodeItem> findBySysCode(String string);

	/**
	 * 查询编码值map  key->code  value->名称
	 * @param string
	 * @return
	 */
	Map<String, String> findMapBySysCode(String string);
}
