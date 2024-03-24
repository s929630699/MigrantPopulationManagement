package com.xmut303.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 罗长久
 * @version 1.0
 */
@Data
public class Health implements Serializable {
    private int id;
    private String idCard;
    private String name;
    private String gender;
    private int age;
    private String bloodType;
    private String healthStatus;
    private String medicalInsurance;
    private String chronicContidion;
    private String notes;



}
