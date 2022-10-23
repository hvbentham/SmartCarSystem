package com.zrxxjd.springboot.mapper;

import com.zrxxjd.springboot.entity.Administrator;
import com.zrxxjd.springboot.entity.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsMapper {
    @Select("select * from goods")
    List<Goods> findAll();

    @Select("select * from goods limit #{pageNum},#{pageSize}")
    List<Goods> selectPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    @Select("select count(*) from goods")
    Integer selectTotal();

    @Insert("insert into goods(color,shelfID,shelfLocation,warehouseID) values (#{color},#{shelfID},#{shelfLocation},#{warehouseID})")
    Integer insert(Goods goods);

    @Delete("delete from goods where goodsID=#{goodsID}")
    int delete(@Param("goodsID") int goodsID);
}
