package com.xmut303.controller;

import com.xmut303.entity.PageResult;
import com.xmut303.entity.Result;
import com.xmut303.pojo.Carry;
import com.xmut303.pojo.Married;
import com.xmut303.pojo.Person;
import com.xmut303.service.CarryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
/**
 * @author wqb
 * @version 1.0
 */
@RestController
@RequestMapping("/carry")
public class CarryController {
    @Autowired
    private CarryService carryService;

    @RequestMapping("/selectCarry")
    public ModelAndView selectCarry(Carry carry,String name, Integer pageNum, Integer pageSize, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();

        if (pageNum == null){
            pageNum = 1;
        }
        if (pageSize == null){
            pageSize = 10;
        }

        //调用service
        PageResult pageResult;
        if (carry.getPID()==null && name==null ){
            System.out.println("搜索全部");
            pageResult = carryService.findAllCarry(pageNum,pageSize);
        }else{
            System.out.println("查询");
            pageResult=carryService.searchCarry(carry,pageNum,pageSize);
        }
        System.out.println(pageResult);
        //页面
        modelAndView.setViewName("carry");

        //数据
        //搜索框数据回显
        modelAndView.addObject("search",carry);
        //分页数据信息
        modelAndView.addObject("pageResult",pageResult);
        //当前页码数
        modelAndView.addObject("pageNum",pageNum);
        //分页请求再次发起的地址
        modelAndView.addObject("gourl",request.getRequestURI());

        return modelAndView;
    }

    @RequestMapping("/addKidCarry")
    @ResponseBody
    public Result addKidCarry(Person person,@RequestParam("carriedID")String carriedID){

        Carry carry = new Carry();
        carry.setCarriedID(carriedID.substring(0,18));
        carry.setPID(person.getIDCard());
        Integer num =carryService.addCarry(carry);
        if (num > 0){
            //成功
            return new Result(true,"添加成功");
        }else {
            return new Result(false,"添加失败");
        }
    }

    @RequestMapping("/addCarry")
    @ResponseBody
    public Result addCarry(Carry carry){
        Integer num =carryService.addCarry(carry);
        if (num > 0){
            //成功
            return new Result(true,"添加成功");
        }else {
            return new Result(false,"添加失败");
        }
    }

    @RequestMapping("/deleteCarry")
    @ResponseBody
    public Result deleteCarry(String PID){
        Integer result=carryService.deleteCarry(PID);
        if (result > 0){
            return new Result(true,"删除成功！");
        }else {
            return new Result(false,"删除失败！");
        }
    }
}
