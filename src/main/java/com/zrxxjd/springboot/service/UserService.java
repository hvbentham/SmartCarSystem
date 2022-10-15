//package com.zrxxjd.springboot.service;
//
//
//import com.zrxxjd.springboot.entity.User;
//import com.zrxxjd.springboot.mapper.UserMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//    @Autowired
//    private UserMapper userMapper;
//
//    public int save(User user){
//        if(user.getId()==null){
//            return userMapper.insert(user);
//        }
//        else{
//            return userMapper.update(user);
//        }
//    }
//}
//集群优先 配置中心
