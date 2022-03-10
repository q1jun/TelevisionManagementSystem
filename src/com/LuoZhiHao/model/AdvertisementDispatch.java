package com.LuoZhiHao.model;

public class AdvertisementDispatch {
    //广告投放编号
    private Integer adId;
    //广告编号
    private Integer aId;//外键
    //投放栏目编号
    private Integer cId;//外键

    public AdvertisementDispatch() {
    }

    public AdvertisementDispatch(Integer adid, Integer aid, Integer cid) {
        this.adId = adid;
        this.aId = aid;
        this.cId = cid;
    }

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "AdvertisementDispatch{" +
                "adid=" + adId +
                ", aid=" + aId +
                ", cid=" + cId +
                '}';
    }
}
