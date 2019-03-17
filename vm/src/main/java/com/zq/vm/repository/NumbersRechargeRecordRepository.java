package com.zq.vm.repository;

import com.zq.vm.entity.NumbersRechargeRecord;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 描述: 余额信息业务数据访问类
 * Time: 2019-02-24 18:48:13
 * @author: zou.qian
 * @version 1.0
 */
public interface NumbersRechargeRecordRepository extends PagingAndSortingRepository<NumbersRechargeRecord,String>, JpaSpecificationExecutor<NumbersRechargeRecord> {


}
