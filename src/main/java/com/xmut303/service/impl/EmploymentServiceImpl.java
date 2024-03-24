package com.xmut303.service.impl;


import com.xmut303.dao.EmploymentMapper;
import com.xmut303.pojo.Employment;
import com.xmut303.pojo.Img;
import com.xmut303.service.EmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 罗长久
 * @version 1.0
 */
@Service
public class EmploymentServiceImpl implements EmploymentService {

    @Autowired
    private EmploymentMapper employmentMapper;
    @Override
    public Employment findEmploymentById(String IDCard) {
        return employmentMapper.findEmploymentById(IDCard);
    }

    @Override
    public int updateEmployment(Employment employment) {
        return employmentMapper.updateEmployee(employment);
    }

    @Override
    public int insertEmployment(String IDCard) {
        return employmentMapper.insertEmployee(IDCard);
    }

    @Override
    public List<Img> findAllCome() {
        return employmentMapper.findAllCome();
    }

    @Override
    public List<Img> findAllSalary() {
        return employmentMapper.findAllSalary();
    }
    @Override
    public List<Img> findAllEmployeeStatus() {
        return employmentMapper.findAllEmployeeStatus();
    }

}
