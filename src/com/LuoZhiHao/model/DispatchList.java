package com.LuoZhiHao.model;

public class DispatchList {
    //调度单编号
    private Integer dId;
    //栏目编号
    private Integer cId;
    //演播厅房间号
    private Integer trvId;
    //员工编号（场协）
    private Integer uId;

    public DispatchList() {
    }

    public DispatchList(Integer did, Integer cid, Integer trvid, Integer uid) {
        this.dId = did;
        this.cId = cid;
        this.trvId = trvid;
        this.uId = uid;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getTrvId() {
        return trvId;
    }

    public void setTrvId(Integer trvId) {
        this.trvId = trvId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    @Override
    public String toString() {
        return "DispatchList{" +
                "did=" + dId +
                ", cid=" + cId +
                ", trvId=" + trvId +
                ", uid=" + uId +
                '}';
    }
}
