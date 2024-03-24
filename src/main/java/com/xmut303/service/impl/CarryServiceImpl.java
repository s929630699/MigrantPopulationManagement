package com.xmut303.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xmut303.dao.CarryMapper;
import com.xmut303.entity.PageResult;
import com.xmut303.pojo.Carry;
import com.xmut303.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author wqb
 * @version 1.0
 */
@Service
public class CarryServiceImpl implements com.xmut303.service.CarryService {
    @Autowired
    private CarryMapper carryMapper;

    @Override
    public PageResult findAllCarry(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Carry> carry = carryMapper.findAllCarry();
        return new PageResult(carry.getTotal(),carry.getResult());
    }

    @Override
    public PageResult searchCarry(Carry carry, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        Page<Carry> page;

        page = carryMapper.searchCarry(carry);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public Integer addCarry(Carry carry) {
        return carryMapper.addCarry(carry);
    }

    @Override
    public Integer deleteCarry(String PID) {
        return carryMapper.deleteCarry(PID);
    }

}
