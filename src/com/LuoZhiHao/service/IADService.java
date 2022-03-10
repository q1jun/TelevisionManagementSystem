package com.LuoZhiHao.service;

import com.LuoZhiHao.model.Advertisement;

import java.util.List;

public interface IADService {
    List<Advertisement> getAllAD();

    void delADById(Integer getaId);
}
