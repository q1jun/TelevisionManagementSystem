package com.LuoZhiHao.model;

public class TelevisionRoom {
    //演播厅房间号
    private Integer tvrId;
    //演播厅面积大小
    private Float tvrSize;

    public TelevisionRoom() {
    }

    public TelevisionRoom(Integer tvrid, Float tvrsize) {
        this.tvrId = tvrid;
        this.tvrSize = tvrsize;
    }

    public Integer getTvrId() {
        return tvrId;
    }

    public void setTvrId(Integer tvrId) {
        this.tvrId = tvrId;
    }

    public Float getTvrSize() {
        return tvrSize;
    }

    public void setTvrSize(Float tvrSize) {
        this.tvrSize = tvrSize;
    }

    @Override
    public String toString() {
        return "TelevisionRoom{" +
                "tvrid=" + tvrId +
                ", tvrsize=" + tvrSize +
                '}';
    }
}
