package com.LuoZhiHao.model;

import java.util.Date;

public class Column {
    //栏目编号
    private Integer cId;
    //栏目名称
    private String cName;
    //播出时间
    private Date cTime;
    //播出时长（秒）
    private Integer cDuration;

    public Column() {
    }

    public Column(Integer cid, String cname, Date ctime, Integer cduration) {
        this.cId = cid;
        this.cName = cname;
        this.cTime = ctime;
        this.cDuration = cduration;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Integer getcDuration() {
        return cDuration;
    }

    public void setcDuration(Integer cDuration) {
        this.cDuration = cDuration;
    }

    @Override
    public String toString() {
        return "Column{" +
                "cid=" + cId +
                ", cname='" + cName + '\'' +
                ", ctime=" + cTime +
                ", cduration=" + cDuration +
                '}';
    }

}
