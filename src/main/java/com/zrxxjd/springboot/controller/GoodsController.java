package com.zrxxjd.springboot.controller;

import com.zrxxjd.springboot.entity.Goods;
import com.zrxxjd.springboot.entity.User;
import com.zrxxjd.springboot.mapper.AdministratorMapper;
import com.zrxxjd.springboot.mapper.GoodsMapper;
import com.zrxxjd.springboot.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsMapper goodsMapper;

    @GetMapping("/get")
    public List<Goods> index(){
        return goodsMapper.findAll();
    }

    @PostMapping("/")
    public Integer insert(@RequestBody Goods goods){
//        Requestbody可以把前台传来的json对象转换成java对象
//        return userservice.save(user);
            return goodsMapper.insert(goods);
    }

    @DeleteMapping("/{id}")
    public int  del(@PathVariable int  id){
        return goodsMapper.delete(id);
    }

    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam  Integer pageSize){
        pageNum=(pageNum-1)*pageSize;
        Integer total=goodsMapper.selectTotal();
        List<Goods> data=goodsMapper.selectPage(pageNum,pageSize);
        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}
