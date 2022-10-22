package com.zrxxjd.springboot.mapper;

import com.zrxxjd.springboot.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from smartcar")
    List<User> findAll();

    @Insert("INSERT into smartcar (sno,position,color,status,time) VALUES(#{sno},#{position},#{color},#{status},#{time})")
    int insert(User user);
    @Delete("delete from smartcar where sno =#{id}")
    int delete(@Param("id") int id);
    @Update("update smartcar set position=#{position},color=#{color},status=#{status},time=#{time} where sno=#{sno}")
    int  update(User user);
    @Select("select * from smartcar limit #{pageNum},#{pageSize}")
    List<User> selectPage(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
    @Select("select count(*) from smartcar")
    Integer selectTotal();
    @Delete("delete from smartcar where sno in (select sno from smartcar limit #{pageNum},#{pageSize} as id);")
    int deleteT(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize );
}
