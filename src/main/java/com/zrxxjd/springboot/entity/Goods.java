package com.zrxxjd.springboot.entity;

import javax.persistence.Entity;
import java.time.format.SignStyle;

@Entity
public class Goods {
    private  Integer goodsId;
    private  String color;
    private  Integer shelfID;
    private  char shelfLocation;
    private  Integer warehouseID;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getShelfID() {
        return shelfID;
    }

    public void setShelfID(Integer shelfID) {
        this.shelfID = shelfID;
    }

    public char getShelfLocation() {
        return shelfLocation;
    }

    public void setShelfLocation(char shelfLocation) {
        this.shelfLocation = shelfLocation;
    }

    public Integer getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(Integer warehouseID) {
        this.warehouseID = warehouseID;
    }
}
