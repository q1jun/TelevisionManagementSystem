package com.LuoZhiHao.service.Impl;

import com.LuoZhiHao.dao.Impl.UserDaoImpl;
import com.LuoZhiHao.model.User;
import com.LuoZhiHao.service.IUserService;
import com.LuoZhiHao.utils.Database;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserServiceImpl implements IUserService {

    UserDaoImpl userDao = new UserDaoImpl();


    @Override
    public boolean certifyUser(String uTel, String uPassword) throws Exception {

        return true;
    }

    @Override
    public List<User> getAllUser() throws Exception {
        return userDao.getAllUser();

    }

    @Override
    public boolean delUserById(Integer uId) throws Exception {
        return userDao.delUserById(uId);
    }

    @Override
    public boolean addUser(User user) throws Exception {
        return userDao.addUser(user);
    }

    @Override
    public boolean updateUser(User user) throws Exception {
        return userDao.updateUser(user);
    }
}
