package com.xmut303.service.impl;


import com.xmut303.dao.HealthMapper;
import com.xmut303.pojo.Health;
import com.xmut303.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 罗长久
 * @version 1.0
 */
@Service
public class HealthServiceImpl implements HealthService {

    @Autowired
    private HealthMapper healthMapper;

    @Override
    public Health findById(String idCard) {
        return  healthMapper.findById(idCard);
    }

    @Override
    public int addHealth(String idCard) {
        return  healthMapper.addHealth(idCard);
    }

    @Override
    public int modifyHealth(Health health) {
        return healthMapper.modifyHealth(health);
    }
}
