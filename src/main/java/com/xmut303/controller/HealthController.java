package com.xmut303.controller;

import com.xmut303.entity.PageResult;
import com.xmut303.entity.Result;
import com.xmut303.pojo.Health;
import com.xmut303.pojo.Person;
import com.xmut303.service.HealthService;
import com.xmut303.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 罗长久
 * @version 1.0
 */
@Controller
@RequestMapping("/health")
public class HealthController {
    @Autowired
    private HealthService healthService;
    @Autowired
    private ResidentService residentService;

    @RequestMapping("/findHealthById")
    @ResponseBody
    public Result<Health> findById(String IDCard){
        System.out.println("idcard "+IDCard);
        Health health = healthService.findById(IDCard);
        //第一次可能为空
        if (health == null){
            int result = healthService.addHealth(IDCard);
            if(result >0){
                health = healthService.findById(IDCard);
            }
        }
//        System.out.println(health);
        return new Result<>(true,"",health);

    }
    @RequestMapping("/searchHealth")
    public ModelAndView searchBorrowed(Person person, Integer pageNum, Integer pageSize, HttpServletRequest request){

        ModelAndView modelAndView = new ModelAndView();

        if (pageNum == null){
            pageNum = 1;
        }
        if (pageSize == null){
            pageSize = 10;
        }

        //调用service
        PageResult pageResult = residentService.searchResident(person,pageNum,pageSize);

        //页面
        modelAndView.setViewName("health");

        //数据
        //搜索框数据回显
        modelAndView.addObject("search",person);
        //分页数据信息
        modelAndView.addObject("pageResult",pageResult);
        //当前页码数
        modelAndView.addObject("pageNum",pageNum);
        //分页请求再次发起的地址
        modelAndView.addObject("gourl",request.getRequestURI());

        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/modifyHealth")
    public Result modifyHealth(Health health){
        System.out.println(health);
        try {
            Integer count = healthService.modifyHealth(health);
            System.out.println(count);
            if (count != 1){
                return  new Result(false,"编辑失败！");
            }
            return new Result(true,"编辑成功！");
        }catch (Exception e){
            e.printStackTrace();
            return  new Result(false,"编辑失败！");
        }

    }
}
