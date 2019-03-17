package com.zq.vm.service.impl;

import com.zq.vm.service.BaseService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseServiceImpl<T,PK> implements BaseService<T,PK> {

    @Override
    public Pageable buildPageRequest(int pageNumber, int pageSize) {
        return PageRequest.of(pageNumber-1, pageSize);
    }

    @Override
    public Pageable buildPageRequest(int pageNumber, int pageSize, Sort.Direction direction, String property) {
        return PageRequest.of(pageNumber-1, pageSize, direction, property);
    }

    @Override
    public List<T> findList(Iterable<T> iterable) {
        List<T> list = new ArrayList<>();
        Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }
}
