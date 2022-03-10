package com.LuoZhiHao.service.Impl;

import com.LuoZhiHao.model.Column;
import com.LuoZhiHao.model.User;
import com.LuoZhiHao.service.IColumnService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ColumnServiceImpl implements IColumnService {
    @Override
    public List<Column> getAllColumn() throws Exception {
        List<Column> columns = new ArrayList<>();
        columns.add(new Column(1,"非诚勿扰",new Date(),3600));
        return columns;
    }

    @Override
    public boolean delColumnById(Integer getcId) throws Exception {
        return true;
    }
}
