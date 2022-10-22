package com.zrxxjd.springboot.service;

import com.zrxxjd.springboot.entity.AdminVO;
import com.zrxxjd.springboot.entity.Administrator;
import com.zrxxjd.springboot.entity.Worker;
import com.zrxxjd.springboot.entity.WorkerVO;
import com.zrxxjd.springboot.mapper.AdministratorMapper;
import com.zrxxjd.springboot.mapper.WorkerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class WorkerService {
    @Autowired
    private WorkerMapper workerMapper;

    public int save(WorkerVO workerVO) {
        Worker worker = new Worker();
        worker.setWorkerID(workerVO.getWorkerID());
        worker.setName(workerVO.getName());
        worker.setGender(workerVO.getGender());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = workerVO.getDob();
//        System.out.println(adminVO.getAdministratorID());
//        System.out.println(adminVO.getDob());
//        System.out.println(adminVO.getName());
        Date date = null;
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            System.out.println(dateString);
        }
        worker.setDOB(date);
        worker.setSalary(workerVO.getSalary());
        worker.setWarehouseID(workerVO.getWarehouseID());
        worker.setAccount(workerVO.getAccount());
        worker.setPassword(workerVO.getPassword());
        return workerMapper.insert(worker);
    }
}
