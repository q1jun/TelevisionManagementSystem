package com.LuoZhiHao.model;

public class User {
    //员工编号
    private Integer uId;
    //员工姓名
    private String uName;
    //员工职位
    private String uPosition;
    //员工性别
    private String uGender;
    //员工生日
    private String uBirthday;
    //员工电话
    private String uTel;
    //员工住址
    private String uAddress;
    //员工的登入密码
    private String uPassword;

    public User() {
    }

    public User(Integer uid, String uname, String uposition, String ugender, String ubirthday, String utel, String uaddress, String upassword) {
        this.uId = uid;
        this.uName = uname;
        this.uPosition = uposition;
        this.uGender = ugender;
        this.uBirthday = ubirthday;
        this.uTel = utel;
        this.uAddress = uaddress;
        this.uPassword = upassword;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPosition() {
        return uPosition;
    }

    public void setuPosition(String uPosition) {
        this.uPosition = uPosition;
    }

    public String getuGender() {
        return uGender;
    }

    public void setuGender(String uGender) {
        this.uGender = uGender;
    }

    public String getuBirthday() {
        return uBirthday;
    }

    public void setuBirthday(String uBirthday) {
        this.uBirthday = uBirthday;
    }

    public String getuTel() {
        return uTel;
    }

    public void setuTel(String uTel) {
        this.uTel = uTel;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uId +
                ", uname='" + uName + '\'' +
                ", uposition='" + uPosition + '\'' +
                ", ugender='" + uGender + '\'' +
                ", ubirthday=" + uBirthday +
                ", utel='" + uTel + '\'' +
                ", uaddress='" + uAddress + '\'' +
                ", upassword='" + uPassword + '\'' +
                '}';
    }
}
