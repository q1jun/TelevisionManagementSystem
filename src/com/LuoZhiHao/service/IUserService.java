package com.LuoZhiHao.service;

import com.LuoZhiHao.model.User;

import java.util.List;

public interface IUserService {
    boolean certifyUser(String uTel, String uPassword) throws Exception;

    List<User> getAllUser()throws Exception;

    boolean delUserById(Integer getuId) throws Exception;

    boolean addUser(User user)throws Exception;

    boolean updateUser(User user)throws Exception;
}
