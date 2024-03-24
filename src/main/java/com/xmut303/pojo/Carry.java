package com.xmut303.pojo;

import lombok.Data;

/**
 * @author wqb
 * @version 1.0
 */

@Data
public class Carry {
    private Integer ID;
    private String PID;
    private String carriedID;
    private Person person;
}
