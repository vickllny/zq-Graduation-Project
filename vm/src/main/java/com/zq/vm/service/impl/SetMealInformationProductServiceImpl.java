package com.zq.vm.service.impl;

import com.zq.vm.repository.SetMealInformationProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.zq.vm.entity.ProductInformation;
import com.zq.vm.entity.ServiceInformation;
import com.zq.vm.entity.SetMealInformationProduct;
import com.zq.vm.entity.vo.SetMealInformationProductVo;
import com.zq.vm.service.ProductInformationService;
import com.zq.vm.service.ServiceInformationService;
import com.zq.vm.service.SetMealInformationProductService;
import com.zq.vm.repository.specification.SetMealInformationProductSpecification;

/**
 * 描述:余额信息业务实现 
 * Time: 2019-02-24 19:07:37
 * @author: zou.qian
 * @version 1.0
 */
@Service
public class SetMealInformationProductServiceImpl extends BaseServiceImpl<SetMealInformationProduct, String> implements SetMealInformationProductService{

	@Autowired
	private SetMealInformationProductRepository setMealInformationProductRepository;
	@Autowired
	private ProductInformationService productInformationService;
	@Autowired
	private ServiceInformationService serviceInformationService;
	
    @Override
    public void delete(String id) {
        setMealInformationProductRepository.deleteById(id);
    }

    @Override
    public SetMealInformationProduct findOne(String id) {
        return setMealInformationProductRepository.findById(id).orElse(new SetMealInformationProduct());
    }

    @Override
    public SetMealInformationProduct save(SetMealInformationProduct setMealInformationProduct) {
        return setMealInformationProductRepository.save(setMealInformationProduct);
    }

    @Override
    public Page<SetMealInformationProduct> findPageByCriteria(int pageNumber, int pageSize, final SetMealInformationProduct setMealInformationProduct) {
    	return setMealInformationProductRepository.findAll(SetMealInformationProductSpecification.specification(setMealInformationProduct), buildPageRequest(pageNumber, pageSize));
    }

	@Override
	public void deleteBySetMealInformationId(String id) {
		setMealInformationProductRepository.deleteBySetMealInformationId(id);
	}

	@Override
	public List<SetMealInformationProductVo> findVoBySetMealInforamtionId(String id) {
		List<SetMealInformationProduct> list = setMealInformationProductRepository.findBySetMealInformationId(id);
		List<SetMealInformationProductVo> vo = new ArrayList<>(list.size());
		list.forEach(bean -> {
			String productName = StringUtils.EMPTY;
			if(bean.getType().equals("1")) {
				ProductInformation product = productInformationService.findOne(bean.getProductId());
				productName = product!=null && StringUtils.isNotBlank(product.getName())? product.getName() : StringUtils.EMPTY;
			}else {
				ServiceInformation service = serviceInformationService.findOne(bean.getProductId());
				productName = service!=null && StringUtils.isNotBlank(service.getName())? service.getName() : StringUtils.EMPTY;
			}
			vo.add(SetMealInformationProductVo.build(bean, productName));
		});
		
		return vo;
	}

	@Override
	public List<SetMealInformationProduct> findBySetMealInforamtionId(String setMealInformationId) {
		return setMealInformationProductRepository.findBySetMealInformationId(setMealInformationId);
	}
}
