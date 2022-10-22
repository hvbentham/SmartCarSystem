package com.zrxxjd.springboot.controller;

import com.zrxxjd.springboot.entity.*;
import com.zrxxjd.springboot.mapper.AdministratorMapper;
import com.zrxxjd.springboot.mapper.WorkerMapper;
import com.zrxxjd.springboot.service.AdministratorService;
import com.zrxxjd.springboot.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    private WorkerMapper workerMapper;
    @Autowired
    private WorkerService workerService;

    @GetMapping("/get")
    public List<Worker> index(){
        return workerMapper.findAll();
    }

    @PostMapping("/")
    public Integer save(@RequestBody WorkerVO workerVO){
        return workerService.save(workerVO);
    }

    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam  Integer pageSize){
        pageNum=(pageNum-1)*pageSize;
        Integer total=workerMapper.selectTotal();
        List<Worker> data=workerMapper.selectPage(pageNum,pageSize);
        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
    @DeleteMapping("/{id}")
    public int  del(@PathVariable int  id){
        return workerMapper.delete(id);
    }
}
