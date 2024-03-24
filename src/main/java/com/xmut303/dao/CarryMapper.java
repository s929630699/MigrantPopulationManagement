package com.xmut303.dao;

import com.github.pagehelper.Page;
import com.xmut303.entity.PageResult;
import com.xmut303.pojo.Carry;
import org.apache.ibatis.annotations.*;

import java.util.List;
/**
 * @author wqb
 * @version 1.0
 */
public interface CarryMapper {
    @Select("select * from carry,person where carry.PID=person.IDCard")
    @Results(id = "findAllCarryMap",value = {
            @Result(id=true,column = "ID",property = "ID"),
            @Result(column = "PID",property = "PID"),
            @Result(column = "carriedID",property = "carriedID"),
            @Result(property = "person",column = "IDCard",
            many = @Many(select = "com.xmut303.dao.PersonMapper.findByIDCard"))
    })
    public Page<Carry> findAllCarry();

    @Select("<script>\n" +
            "            select * from carry,person\n" +
            "            <where>\n" +
            "                carry.PID=person.IDCard\n"+
            "                <if test=\"PID != null and PID.trim() != ''\">\n" +
            "                    and PID like concat('%',#{PID},'%')\n" +
            "                </if>\n" +
            "                <if test=\"carriedID != null and carriedID.trim() != ''\">\n" +
            "                    and carry.carriedID like concat('%',#{carriedID},'%')\n" +
            "                </if>\n" +
            "            </where>\n" +
            "        </script>")
    @Results(id="searchCarryMap",value = {
            @Result(id=true,column = "ID",property = "ID"),
            @Result(column = "PID",property = "PID"),
            @Result(column = "carriedID",property = "carriedID"),
            @Result(property = "person",column = "IDCard",
                    many = @Many(select = "com.xmut303.dao.PersonMapper.findByIDCard"))
    })
    public Page<Carry> searchCarry(Carry carry);

    @Insert("insert into carry (PID,carriedID) values (#{PID},#{carriedID})")
    public Integer addCarry(Carry carry);

    @Delete("delete from carry where PID=#{PID}")
    public Integer deleteCarry(String PID);

}
