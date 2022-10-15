package com.zrxxjd.springboot;

import com.zrxxjd.springboot.entity.User;
import com.zrxxjd.springboot.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@SpringBootApplication
public class SpringbootApplication {


    public static void main(String[] args) { SpringApplication.run(SpringbootApplication.class, args); }

}
