package com.LuoZhiHao.service.Impl;

import com.LuoZhiHao.model.DispatchList;
import com.LuoZhiHao.service.IDispatchService;

import java.util.ArrayList;
import java.util.List;

public class DispatchServiceImpl implements IDispatchService {
    @Override
    public List<DispatchList> getAlldispatch() {
        List<DispatchList> dispatchLists = new ArrayList<>();
        dispatchLists.add(new DispatchList(1,101,202,1));
        dispatchLists.add(new DispatchList(2,102,201,1));
        dispatchLists.add(new DispatchList(3,100,203,1));
        dispatchLists.add(new DispatchList(4,103,200,1));

        return dispatchLists;
    }

    @Override
    public void delDispatchById(Integer getcId) {

    }
}
