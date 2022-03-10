package com.LuoZhiHao.service.Impl;

import com.LuoZhiHao.model.Advertisement;
import com.LuoZhiHao.service.IADService;

import java.util.ArrayList;
import java.util.List;

public class ADServiceImpl implements IADService {
    @Override
    public List<Advertisement> getAllAD() {
        List<Advertisement> advertisements = new ArrayList<>();
        advertisements.add(new Advertisement(200,300.00F));
        advertisements.add(new Advertisement(201,800.00F));
        return advertisements;
    }

    @Override
    public void delADById(Integer getaId) {

    }
}
