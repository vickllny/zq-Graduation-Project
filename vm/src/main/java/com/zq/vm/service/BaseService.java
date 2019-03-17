package com.zq.vm.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BaseService<T,PK> {
    /**
     * 构建pageRequest
     * @param pageNumber
     * @param pageSize
     * @return
     */
    Pageable buildPageRequest(int pageNumber, int pageSize);

    /**
     * 构建pageRequest
     * @param pageNumber
     * @param pageSize
     * @param direction
     * @param property
     * @return
     */
    Pageable buildPageRequest(int pageNumber, int pageSize, Sort.Direction direction, String property);


    List<T> findList(Iterable<T> iterable);
}
