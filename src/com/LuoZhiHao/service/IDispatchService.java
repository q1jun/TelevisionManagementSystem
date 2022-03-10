package com.LuoZhiHao.service;

import com.LuoZhiHao.model.DispatchList;

import java.util.List;

public interface IDispatchService {
    List<DispatchList> getAlldispatch();

    void delDispatchById(Integer getcId);
}
