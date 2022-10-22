package com.zrxxjd.springboot.mapper;

import com.zrxxjd.springboot.entity.Administrator;
import com.zrxxjd.springboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdministratorMapper {
   @Select("select administratorID from administrator where account=#{account} and password=#{password}")
    Integer validWorker(@Param("account") String account,@Param("password") String password);

   @Update("update administrator set name=#{name},gender=#{gender},DOB=#{DOB} where administratorID=#{administratorID}")
    Integer update(Administrator administrator);

   @Insert("insert into administrator(administratorID,name,gender,DOB,salary,account,password) values (#{administratorID},#{name},#{gender},#{DOB},#{salary},#{account},#{password})")
    Integer insert(Administrator administrator);

    @Select("select count(*) from administrator")
    Integer selectTotal();

    @Select("select * from administrator limit #{pageNum},#{pageSize}")
    List<Administrator> selectPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    @Select("select * from administrator")
    List<Administrator> findAll();

    @Delete("delete from administrator where administratorID=#{administratorID}")
    int delete(@Param("administratorID") int administratorID);
}
