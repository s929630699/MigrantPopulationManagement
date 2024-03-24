package com.xmut303.dao;

import com.xmut303.pojo.Health;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author 罗长久
 * @version 1.0
 */
public interface HealthMapper {

    //按person_id健康记录
    @Select("SELECT * FROM health,person WHERE person.IDCard = health.person_idCard and health.person_idCard = #{idCard}")
    @Results(id = "healthMap",value = {
            @Result(id =true,column = "health_id",property = "id"),
            @Result(column = "person_idCard",property = "idCard"),
            @Result(column = "name",property = "name"),
            @Result(column = "sex",property = "gender"),
            @Result(column = "age",property = "age"),
            @Result(column = "blood_type",property = "bloodType"),
            @Result(column = "health_status",property = "healthStatus"),
            @Result(column = "medical_insurance",property = "medicalInsurance"),
            @Result(column = "chronic_condition",property = "chronicContidion"),
            @Result(column = "notes",property = "notes"),
    })
    public Health findById(String idCard);

    //修改健康记录
    public int modifyHealth(Health health);

    //新增health

    /**
     * 此处是personid
     * @param idCard
     * @return
     */
    @Insert("insert into health(person_idCard) values(#{arg1})")
    public int addHealth(String idCard);
}
