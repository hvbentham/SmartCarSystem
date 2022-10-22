package com.zrxxjd.springboot.controller;

import com.zrxxjd.springboot.entity.Goods;
import com.zrxxjd.springboot.entity.Shelf;
import com.zrxxjd.springboot.mapper.GoodsMapper;
import com.zrxxjd.springboot.mapper.ShelfMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shelf")
public class ShelfController {
    @Autowired
    private ShelfMapper shelfMapper;

    @GetMapping("/get")
    public List<Shelf> index(){
        return shelfMapper.findAll();
    }

    @PostMapping("/")
    public Integer insert(@RequestBody Shelf shelf){
//        Requestbody可以把前台传来的json对象转换成java对象
//        return userservice.save(user);
        return shelfMapper.insert(shelf);
    }

    @DeleteMapping("/{id}")
    public int  del(@PathVariable int  id){
        return shelfMapper.delete(id);
    }

    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam  Integer pageSize){
        pageNum=(pageNum-1)*pageSize;
        Integer total=shelfMapper.selectTotal();
        List<Shelf> data=shelfMapper.selectPage(pageNum,pageSize);
        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}
