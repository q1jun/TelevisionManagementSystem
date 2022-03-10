package com.LuoZhiHao.dao;

import com.LuoZhiHao.model.User;

import java.util.List;

public interface IUserDao {
    List<User> getAllUser() throws Exception;

    boolean delUserById(Integer uId) throws Exception;

    boolean addUser(User user) throws Exception;

    boolean updateUser(User user) throws Exception;
}
