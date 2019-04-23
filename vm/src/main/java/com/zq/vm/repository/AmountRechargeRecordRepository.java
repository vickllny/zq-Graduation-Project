package com.zq.vm.repository;

import com.zq.vm.entity.AmountRechargeRecord;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 描述: 余额充值记录业务数据访问类
 * Time: 2019-03-23 12:49:34
 * @author: zou.qian
 * @version 1.0
 */
public interface AmountRechargeRecordRepository extends PagingAndSortingRepository<AmountRechargeRecord,String>, JpaSpecificationExecutor<AmountRechargeRecord> {


}
