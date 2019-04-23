package com.zq.vm.service.impl;

import com.zq.vm.repository.SetMealInformationRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.SetMealInformation;
import com.zq.vm.entity.SetMealInformationProduct;
import com.zq.vm.entity.vo.SetMealInformationVo;
import com.zq.vm.service.SetMealInformationProductService;
import com.zq.vm.service.SetMealInformationService;
import com.zq.vm.repository.specification.SetMealInformationSpecification;

import java.util.List;

/**
 * 描述:套餐管理业务实现 
 * Time: 2019-03-25 22:25:50
 * @author: zou.qian
 * @version 1.0
 */
@Service
@Transactional
public class SetMealInformationServiceImpl extends BaseServiceImpl<SetMealInformation, String> implements SetMealInformationService{

	@Autowired
	private SetMealInformationRepository setMealInformationRepository;
	@Autowired
	private SetMealInformationProductService setMealInformationProductService;
	
    @Override
    public void delete(String id) {
        setMealInformationRepository.deleteById(id);
    }

    @Override
    public SetMealInformation findOne(String id) {
        return setMealInformationRepository.findById(id).orElse(new SetMealInformation());
    }

    @Override
    public SetMealInformation save(SetMealInformation setMealInformation) {
        return setMealInformationRepository.save(setMealInformation);
    }

    @Override
    public Page<SetMealInformation> findPageByCriteria(int pageNumber, int pageSize, final SetMealInformation setMealInformation) {
    	return setMealInformationRepository.findAll(SetMealInformationSpecification.specification(setMealInformation), buildPageRequest(pageNumber, pageSize));
    }

    @Override
    public List<SetMealInformation> findAll() {
        return super.findList(setMealInformationRepository.findAll());
    }

	@Override
	public void saveProduct(SetMealInformationVo vo) {
		String id = vo.getId();
		List<SetMealInformationProduct> data = vo.getData();
		//删除之前保存的
		setMealInformationProductService.deleteBySetMealInformationId(id);
		if(CollectionUtils.isNotEmpty(data)) {
			data.forEach(product -> {
				setMealInformationProductService.save(product);
			});
		}
	}
}
