package com.zrxxjd.springboot.entity;

import javax.persistence.Entity;

@Entity
public class Shelf {
    private char shelfLocation;
    private Integer shelfID;
    private Integer warehouseID;
    private Integer total;
    private Integer idle;

    public char getShelfLocation() {
        return shelfLocation;
    }

    public void setShelfLocation(char shelfLocation) {
        this.shelfLocation = shelfLocation;
    }

    public Integer getShelfID() {
        return shelfID;
    }

    public void setShelfID(Integer shelfID) {
        this.shelfID = shelfID;
    }

    public Integer getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(Integer warehouseID) {
        this.warehouseID = warehouseID;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getIdle() {
        return idle;
    }

    public void setIdle(Integer idle) {
        this.idle = idle;
    }
}
