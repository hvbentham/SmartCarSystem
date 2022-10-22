package com.zrxxjd.springboot.mapper;

import com.zrxxjd.springboot.entity.Administrator;
import com.zrxxjd.springboot.entity.Worker;
import com.zrxxjd.springboot.entity.WorkerVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WorkerMapper {
    @Delete("delete from worker where workerID=#{workerID}")
    int delete(@Param("workerID") int workerID);

    @Select("select * from worker")
    List<Worker> findAll();

    @Select("select * from worker limit #{pageNum},#{pageSize}")
    List<Worker> selectPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    @Select("select count(*) from worker")
    Integer selectTotal();

    @Insert("insert into worker(name,gender,DOB,salary,warehouseID,account,password) values (#{name},#{gender},#{DOB},#{salary},#{warehouseID},#{account},#{password})")
    Integer insert(Worker worker);

    @Update("update worker set name=#{name},gender=#{gender},DOB=#{DOB},salary=#{salary},warehouseID=#{warehouseID},account=#{account},password=#{password} where workerID=#{workerID}")
    Integer update(Worker worker);


}
