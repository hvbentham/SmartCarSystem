package com.zrxxjd.springboot.controller;

import com.zrxxjd.springboot.entity.AdminVO;
import com.zrxxjd.springboot.entity.Administrator;
import com.zrxxjd.springboot.entity.User;
import com.zrxxjd.springboot.mapper.AdministratorMapper;

import com.zrxxjd.springboot.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/admin")
public class AdministratorController {
    @Autowired
    private AdministratorMapper administratorMapper;
    @Autowired
    private AdministratorService administratorService;

    @GetMapping("/valid")
    public Integer Valid(@RequestBody Administrator administrator){
      return administratorService.valid(administrator);
    }

    @PostMapping("/")
    public Integer save(@RequestBody AdminVO adminVO){
        return administratorService.save(adminVO);
    }

    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam  Integer pageSize){
        pageNum=(pageNum-1)*pageSize;
        Integer total=administratorMapper.selectTotal();
        List<Administrator> data=administratorMapper.selectPage(pageNum,pageSize);
        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    @GetMapping("/get")
    public List<Administrator> index(){
        return administratorMapper.findAll();
    }

}
