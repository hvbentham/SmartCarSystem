package com.zrxxjd.springboot.mapper;

import com.zrxxjd.springboot.entity.User;
import com.zrxxjd.springboot.entity.Warehouse;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WarehouseMapper {
    @Insert("INSERT into warehouse (total,idle) VALUES(#{total},#{idle})")
    int insert(Warehouse warehouse);

    @Delete("delete from warehouse where warehouseID=#{id}")
    int del(@Param("id") int id);

    @Update("update warehouse set idle=#{idle} where warehouseID=#{warehouseID}")
    int  update(Warehouse warehouse);

    @Select("select * from warehouse")
    List<Warehouse> findAll();
}
