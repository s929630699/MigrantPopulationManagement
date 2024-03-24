package com.xmut303.controller;

import com.xmut303.entity.Result;
import com.xmut303.pojo.Img;
import com.xmut303.service.EmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 罗长久
 * @version 1.0
 */
@Controller
@RequestMapping("big")
public class BigController {
    @Autowired
    private EmploymentService employmentService;

    @RequestMapping("/show")
    @ResponseBody
    public ModelAndView show(){
        System.out.println("show yes");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bigdata");
        return modelAndView;
    }

    @RequestMapping("/findAllCome")
    @ResponseBody
    public Result<List<Img>> findAllCome(){
        System.out.println("访问了");
        List<Img> allSalary = employmentService.findAllCome();
        if(allSalary.size()>0) {
            return new Result<>(true, "", allSalary);
        }else {
            return new Result<>(false, "");
        }

    }
    @RequestMapping("/findAllSalary")
    @ResponseBody
    public Result<List<Img>> findAllSalary(){
        System.out.println("访问了");
        List<Img> allSalary = employmentService.findAllSalary();
        if(allSalary.size()>0) {
            return new Result<>(true, "", allSalary);
        }else {
            return new Result<>(false, "");
        }

    }

    @RequestMapping("/findAllEmployeeStatus")
    @ResponseBody
    public Result<List<Img>> findAllEmployeeStatus(){
        System.out.println("访问了");
        List<Img> allSalary = employmentService.findAllEmployeeStatus();
        if(allSalary.size()>0) {
            return new Result<>(true, "", allSalary);
        }else {
            return new Result<>(false, "");
        }

    }
}
