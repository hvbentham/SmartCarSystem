package com.zrxxjd.springboot.mapper;

import com.zrxxjd.springboot.entity.Goods;
import com.zrxxjd.springboot.entity.Shelf;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShelfMapper {
    @Select("select * from shelf")
    List<Shelf> findAll();

    @Select("select * from shelf limit #{pageNum},#{pageSize}")
    List<Shelf> selectPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    @Select("select count(*) from shelf")
    Integer selectTotal();

    @Insert("insert into shelf(shelfLocation,shelfID,warehouseID,total,idle) values (#{shelfLocation},#{shelfID},#{warehouseID},#{total},#{idle})")
    Integer insert(Shelf shelf);

    @Delete("delete from shelf where shelfID=#{shelfID}")
    int delete(@Param("shelfID") int shelfID);
}
