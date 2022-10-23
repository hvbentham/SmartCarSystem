package com.zrxxjd.springboot.controller;

import com.zrxxjd.springboot.entity.User;
import com.zrxxjd.springboot.entity.Warehouse;
import com.zrxxjd.springboot.mapper.UserMapper;
import com.zrxxjd.springboot.mapper.WarehouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ware")
public class WarehouseController {
    @Autowired
    private WarehouseMapper warehouseMapper;

    @GetMapping("/get")
    public List<Warehouse> index(){
        return warehouseMapper.findAll();
    }

    @PostMapping("/")
    public Integer insert(@RequestBody Warehouse warehouse) {
    return warehouseMapper.insert(warehouse);
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable int  id){
        return warehouseMapper.del(id);
    }

    @PostMapping("/update")
    public Integer update(@RequestBody Warehouse warehouse){
        return warehouseMapper.update(warehouse);
    }
}
