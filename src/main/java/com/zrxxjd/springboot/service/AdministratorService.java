package com.zrxxjd.springboot.service;

import com.zrxxjd.springboot.entity.AdminVO;
import com.zrxxjd.springboot.entity.Administrator;
import com.zrxxjd.springboot.mapper.AdministratorMapper;
import com.zrxxjd.springboot.utils.JwtUtils;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class AdministratorService {
    @Autowired
    private AdministratorMapper administratorMapper;

    public Map<String ,Object> valid(Administrator administrator){
        Administrator admin=administratorMapper.findByUsernameAndPassword(administrator);
        Map<String,Object> map=new HashMap<>();
        map.put("user",admin);
        if(Objects.isNull(admin)){
            map.put("token",null);
            return map;
        }

        admin.setPassword(null);
        //生成Token并返回
        String token = JwtUtils.generateToken(administrator.getAccount());
        map.put("token",token);
        return map;
    }

    public int save(AdminVO adminVO) {
        Administrator administrator = new Administrator();
        administrator.setAdministratorID(adminVO.getAdministratorID());
        administrator.setName(adminVO.getName());
        administrator.setGender(adminVO.getGender());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = adminVO.getDob();
//        System.out.println(adminVO.getAdministratorID());
//        System.out.println(adminVO.getDob());
//        System.out.println(adminVO.getName());
        Date date = null;
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            System.out.println(dateString);
        }
        administrator.setDOB(date);
        administrator.setSalary(adminVO.getSalary());
        administrator.setAccount(adminVO.getAccount());
        administrator.setPassword(adminVO.getPassword());
        if (adminVO.getAdministratorID() == null) {
            return administratorMapper.insert(administrator);
        } else {
            return administratorMapper.update(administrator);
        }
    }

}
