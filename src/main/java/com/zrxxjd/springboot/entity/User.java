package com.zrxxjd.springboot.entity;

//import lombok.AllArgsConstructor;
//import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;

@Entity
public class User {
    private Integer sno;
    private long position;
    private long time;
    private String color;
    private String status;

    public User() {
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public void setPosition(long position) {
        this.position = position;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSno() {
        return sno;
    }

    public long getPosition() {
        return position;
    }

    public long getTime() {
        return time;
    }

    public String getColor() {
        return color;
    }

    public String getStatus() {
        return status;
    }
}
