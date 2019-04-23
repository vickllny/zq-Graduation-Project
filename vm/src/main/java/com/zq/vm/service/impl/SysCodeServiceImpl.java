package com.zq.vm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zq.vm.entity.SysCode;
import com.zq.vm.repository.SysCodeRepository;
import com.zq.vm.repository.specification.SysCodeSpecification;
import com.zq.vm.service.SysCodeService;

/**
 * 描述:系统code业务实现 
 * Time: 2019-04-14 14:23:49
 * @author: zou.qian
 * @version 1.0
 */
@Service
@Transactional
public class SysCodeServiceImpl extends BaseServiceImpl<SysCode, String> implements SysCodeService{

	@Autowired
	private SysCodeRepository sysCodeRepository;
	
    @Override
    public void delete(String id) {
        sysCodeRepository.deleteById(id);
    }

    @Override
    public SysCode findOne(String id) {
        return sysCodeRepository.findById(id).orElse(new SysCode());
    }

    @Override
    public SysCode save(SysCode sysCode) {
        return sysCodeRepository.save(sysCode);
    }

    @Override
    public Page<SysCode> findPageByCriteria(int pageNumber, int pageSize, final SysCode sysCode) {
    	return sysCodeRepository.findAll(SysCodeSpecification.specification(sysCode), buildPageRequest(pageNumber, pageSize));
    }

    @Override
    public List<SysCode> findAll() {
        return super.findList(sysCodeRepository.findAll());
    }

	@Override
	public SysCode findByCode(String code) {
		return sysCodeRepository.findByCode(code);
	}

	@Override
	public SysCode findByNameAndIdNot(String name, String id) {
		return sysCodeRepository.findByNameAndIdNot(name, id);
	}

	@Override
	public SysCode findByCodeAndIdNot(String code, String id) {
		return sysCodeRepository.findByCodeAndIdNot(code, id);
	}
}
