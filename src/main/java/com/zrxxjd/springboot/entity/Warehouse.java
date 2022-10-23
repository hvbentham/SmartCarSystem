package com.zrxxjd.springboot.entity;

import javax.persistence.Entity;

@Entity
public class Warehouse {
    private Integer warehouseID;
    private Integer total;
    private  Integer idle;

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
