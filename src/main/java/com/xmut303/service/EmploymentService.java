package com.xmut303.service;


import com.xmut303.pojo.Employment;
import com.xmut303.pojo.Img;

import java.util.List;

/**
 * @author 罗长久
 * @version 1.0
 */
public interface EmploymentService {

    public Employment findEmploymentById(String IDCard);

    public int updateEmployment(Employment employment);

    public int insertEmployment(String IDCard);

    public List<Img> findAllCome();

    public List<Img> findAllSalary();
    public List<Img> findAllEmployeeStatus();
}
