package com.LuoZhiHao.model;

public class Advertisement {
    //广告编号
    private Integer aId;
    //广告投放价格
    private Float aPrice;

    public Advertisement() {
    }

    public Advertisement(Integer aid, Float aprice) {
        this.aId = aid;
        this.aPrice = aprice;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Float getaPrice() {
        return aPrice;
    }

    public void setaPrice(Float aPrice) {
        this.aPrice = aPrice;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "aid=" + aId +
                ", aprice=" + aPrice +
                '}';
    }
}
