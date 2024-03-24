package com.xmut303.controller;

import com.xmut303.entity.PageResult;
import com.xmut303.entity.Result;
import com.xmut303.pojo.Employment;
import com.xmut303.pojo.Person;
import com.xmut303.service.EmploymentService;
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
@RequestMapping("employee")
public class EmploymentController {

    @Autowired
    private ResidentService residentService;
    @Autowired
    private EmploymentService employmentService;

    @RequestMapping("/searchEmployee")
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
        modelAndView.setViewName("employment");

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

    @RequestMapping("findEmploymentById")
    @ResponseBody
    public Result<Employment> findEmploymentById(String IDCard){
        System.out.println(IDCard);

        Employment employmentById = employmentService.findEmploymentById(IDCard);
        if (employmentById == null){
            employmentService.insertEmployment(IDCard);
            employmentById = employmentService.findEmploymentById(IDCard);
        }
        System.out.println(employmentById);
        return new Result<>(true,"",employmentById);

    }
    @RequestMapping("modifyEmployment")
    public Result modifyEmployment(Employment employment){
        System.out.println(employment);
        int i = employmentService.updateEmployment(employment);
        if (i == 0){
            return  new Result(false,"修改失败！");

        }
        return  new Result(true,"修改成功！");

    }

//    @RequestMapping("findAllSalary")
//    public  Result<List<Img>> findAllSalary(){
//        System.out.println("访问了");
//        List<Img> allSalary = employmentService.findAllSalary();
//        return new Result<>(true,"",allSalary);
//
//    }
}
