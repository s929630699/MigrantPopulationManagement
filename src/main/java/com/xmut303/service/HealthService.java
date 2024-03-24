package com.xmut303.service;


import com.xmut303.pojo.Health;

/**
 * @author 罗长久
 * @version 1.0
 */
public interface HealthService {

    public Health findById(String idCard);

    public int addHealth(String idCard);

    public int modifyHealth(Health health);
}
