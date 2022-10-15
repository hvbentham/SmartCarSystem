package com.zrxxjd.springboot.controller;


import com.zrxxjd.springboot.entity.User;
import com.zrxxjd.springboot.mapper.UserMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {


    @Autowired
    private UserMapper userMapper;


//    @Resource
//    private UserService userservice;

    @GetMapping("/get")
    public List<User> index(){
        return userMapper.findAll();
    }
    @PostMapping("/")
    public Integer save(@RequestBody User user){
//        Requestbody可以把前台传来的json对象转换成java对象
//        return userservice.save(user);
        if(user.getSno()==null){
            return userMapper.insert(user);
        }
        else{
            return userMapper.update(user);
        }

    }

    @DeleteMapping("/{id}")
    public int  del(@PathVariable int  id){
        return userMapper.delete(id);
    }

    @CrossOrigin
    @RequestMapping("/test")
    public String test(){
        return "hello";
    }
    @CrossOrigin
    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam  Integer pageSize){
        pageNum=(pageNum-1)*pageSize;
        Integer total=userMapper.selectTotal();
        List<User> data=userMapper.selectPage(pageNum,pageSize);
        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}
