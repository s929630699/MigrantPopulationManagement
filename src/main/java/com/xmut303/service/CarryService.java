package com.xmut303.service;

import com.xmut303.entity.PageResult;
import com.xmut303.pojo.Carry;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/**
 * @author wqb
 * @version 1.0
 */
public interface CarryService {
    public PageResult findAllCarry(Integer pageNum, Integer pageSize);

    public PageResult searchCarry(Carry carry,Integer pageNum, Integer pageSize);

    public Integer addCarry(Carry carry);

    public Integer deleteCarry(String PID);

}
