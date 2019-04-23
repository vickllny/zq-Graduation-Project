package com.zq.vm.repository;

import com.zq.vm.entity.SysCodeItem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 描述: 系统编码值业务数据访问类
 * Time: 2019-04-14 16:00:27
 * @author: zou.qian
 * @version 1.0
 */
public interface SysCodeItemRepository extends PagingAndSortingRepository<SysCodeItem,String>, JpaSpecificationExecutor<SysCodeItem> {

    /**
     * 根据codeId查询codeItem
     * @param codeId
     * @return
     */
	List<SysCodeItem> findBySysCodeId(String codeId);
}
