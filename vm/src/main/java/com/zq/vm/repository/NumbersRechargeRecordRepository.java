package com.zq.vm.repository;

import com.zq.vm.entity.NumbersRechargeRecord;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 描述: 服务次数充值记录表业务数据访问类
 * Time: 2019-04-17 23:37:10
 * @author: zou.qian
 * @version 1.0
 */
public interface NumbersRechargeRecordRepository extends PagingAndSortingRepository<NumbersRechargeRecord,String>, JpaSpecificationExecutor<NumbersRechargeRecord> {


}
