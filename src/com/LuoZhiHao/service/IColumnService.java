package com.LuoZhiHao.service;

import com.LuoZhiHao.model.Column;
import com.LuoZhiHao.model.User;

import java.util.List;

public interface IColumnService {
    List<Column> getAllColumn() throws Exception;

    boolean delColumnById(Integer getcId)throws Exception;
}
