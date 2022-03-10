package com.LuoZhiHao.dao.Impl;

import com.LuoZhiHao.dao.IUserDao;
import com.LuoZhiHao.model.User;
import com.LuoZhiHao.utils.Database;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public List<User> getAllUser() throws Exception {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM `user`";
        ResultSet resultSet = Database.query(sql);
        while (resultSet.next()){
            User user = new User();
            user.setuId(resultSet.getInt("uid"));
            user.setuName(resultSet.getString("uname"));
            user.setuPosition(resultSet.getString("uposition"));
            user.setuGender(resultSet.getString("ugender"));
            Date date = new Date(resultSet.getDate("ubirthday").getTime());
            user.setuBirthday(simpleDateFormat.format(date));
            user.setuTel(resultSet.getString("utel"));
            user.setuAddress(resultSet.getString("uaddress"));
            user.setuPassword(resultSet.getString("upassword"));
            System.out.println(user);
            users.add(user);
        }
        Database.releaseAll();
//        users.add(new User(1,"Alan","HR","男","2000-02-21","15770779257","江西省南昌市","123"));
//        users.add(new User(2,"Bob","HR","男","2000-02-22","15770779258","江西省南昌市","123"));

        return users;
    }

    @Override
    public boolean delUserById(Integer uId) throws Exception {
        String sql = "DELETE FROM `user` where uid = "+ uId +" ;";
        return Database.update(sql) == 0?false:true;
    }

    @Override
    public boolean addUser(User user) throws Exception {
        String sql = "INSERT INTO `user` (`uid`, `uname`, `uposition`, `ugender`, `ubirthday`, `utel`, `uaddress`, `upassword`) " +
                "VALUES (" + user.getuId() +
                ", '" +user.getuName() +
                "', '" +user.getuPosition() +
                "', '" + user.getuGender() +
                "', '" + new java.sql.Date(simpleDateFormat.parse(user.getuBirthday()).getTime()) +
                "', '" + user.getuTel() +
                "', '" + user.getuAddress() +
                "', '" + user.getuPassword() +
                "');"
                ;
        int sign = Database.update(sql);
        Database.releaseAll();
        return sign != 0;
    }

    @Override
    public boolean updateUser(User user) throws Exception {
        String sql = "UPDATE `user` SET `uid` = '" + user.getuId() +
                "', `uname` = '" + user.getuName() +
                "', `uposition` = '" + user.getuPosition() +
                "', `ugender` = '" + user.getuGender() +
                "', `ubirthday` = '" + new java.sql.Date(simpleDateFormat.parse(user.getuBirthday()).getTime()) +
                "', `utel` = '" + user.getuTel() +
                "', `uaddress` = '" + user.getuAddress() +
                "', `upassword`= '" + user.getuPassword() +
                "' WHERE `uid` = " + user.getuId() +
                " ;";
        int sign = Database.update(sql);
        Database.releaseAll();
        return sign != 0;
    }


}
