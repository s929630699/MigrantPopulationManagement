package com.xmut303.dao;


import com.xmut303.pojo.Employment;
import com.xmut303.pojo.Img;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 罗长久
 * @version 1.0
 */
public interface EmploymentMapper {
    //查询就业信息
    public Employment findEmploymentById(String IDCard);

    //修改就业信息
    @Update("update employment set employment_status = #{status},company_name=#{companyName},company_address=#{companyAddress},salary=#{salary},notes = #{notes} where employment_id = #{id}")
    public int updateEmployee(Employment employment);

    //为空时新增
    @Insert("insert into employment(person_idCard) values(#{arg1})")
    public int insertEmployee(String IDCard);

    //查询工资信息
    @Select("SELECT domicileplace,count(*) as number from person GROUP BY domicileplace HAVING domicileplace != ''")
    @Results(id = "ComeMap",value = {
            @Result(column = "domicileplace",property = "name"),
            @Result(column = "number",property = "value"),

    })
    public List<Img> findAllCome();

    @Select("SELECT salary ,count(*) as number from employment GROUP BY salary HAVING salary != ''")
    @Results(id = "SalaryMap",value = {
            @Result(column = "salary",property = "name"),
            @Result(column = "number",property = "value"),

    })
    public List<Img> findAllSalary();


    @Select("SELECT employment_status ,count(*) as number from employment GROUP BY employment_status HAVING employment_status != ''")
    @Results(id = "EmployeeStatusMap",value = {
            @Result(column = "employment_status",property = "name"),
            @Result(column = "number",property = "value"),

    })
    public List<Img> findAllEmployeeStatus();

}
