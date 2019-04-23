package com.zq.vm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.zq.vm.entity.SysCodeItem;
import com.zq.vm.entity.vo.SysCodeItemVo;
import com.zq.vm.repository.SysCodeItemRepository;
import com.zq.vm.repository.specification.SysCodeItemSpecification;
import com.zq.vm.service.SysCodeItemService;
import com.zq.vm.service.SysCodeService;

/**
 * 描述:系统编码值业务实现 
 * Time: 2019-04-14 16:00:27
 * @author: zou.qian
 * @version 1.0
 */
@Service
public class SysCodeItemServiceImpl extends BaseServiceImpl<SysCodeItem, String> implements SysCodeItemService{

	@Autowired
	private SysCodeItemRepository sysCodeItemRepository;
	@Autowired
	private SysCodeService sysCodeService;
	
    @Override
    public void delete(String id) {
        sysCodeItemRepository.deleteById(id);
    }

    @Override
    public SysCodeItem findOne(String id) {
        return sysCodeItemRepository.findById(id).orElse(new SysCodeItem());
    }

    @Override
    public SysCodeItem save(SysCodeItem sysCodeItem) {
        return sysCodeItemRepository.save(sysCodeItem);
    }

    @Override
    public Page<SysCodeItem> findPageByCriteria(int pageNumber, int pageSize, final SysCodeItem sysCodeItem) {
    	return sysCodeItemRepository.findAll(SysCodeItemSpecification.specification(sysCodeItem), buildPageRequest(pageNumber, pageSize));
    }

    @Override
    public List<SysCodeItem> findAll() {
        return super.findList(sysCodeItemRepository.findAll());
    }

	@Override
	public List<SysCodeItem> findBySysCodeId(String codeId) {
		return sysCodeItemRepository.findBySysCodeId(codeId);
	}

	@Override
	public void save(SysCodeItemVo vo) {
		List<SysCodeItem> list = vo.getList();
		for (SysCodeItem sysCodeItem : list) {
			save(sysCodeItem);
		}
	}

	@Override
	public List<SysCodeItem> findBySysCode(String code) {
		List<SysCodeItem> list = new ArrayList<>();
		Optional.ofNullable(sysCodeService.findByCode(code))
			.ifPresent(sysCode -> {
				List<SysCodeItem> items = findBySysCodeId(sysCode.getId());
				list.addAll(items);
			});
		return list;
	}

	@Override
	public Map<String, String> findMapBySysCode(String code) {
		List<SysCodeItem> list = findBySysCode(code);
		Map<String, String> map = new HashMap<>();
		list.forEach(item -> map.put(item.getCode(), item.getName()));
		return map;
	}
}
