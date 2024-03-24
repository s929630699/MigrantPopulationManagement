package com.xmut303.controller;

import com.github.pagehelper.Page;
import com.xmut303.entity.PageResult;
import com.xmut303.entity.Result;
import com.xmut303.pojo.Married;
import com.xmut303.pojo.MarriedFlag;
import com.xmut303.pojo.Person;
import com.xmut303.service.MarriedService;
import com.xmut303.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * @author JokkiePan
 * @vision 1.0
 * @createDate 2023/5/9 11:24
 */

@Controller
@RequestMapping("/married")
public class MarriedController {

    @Autowired
    private MarriedService marriedService;

    @Autowired
    private PersonService personService;

    /**
     * 模糊查询结婚信息显示在页面
     * @param married
     * @param pageNum
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping("/searchMarried")
    @ResponseBody
    public ModelAndView searchMarried(Married married, Integer pageNum, Integer pageSize, HttpServletRequest request){
     ModelAndView modelAndView = new ModelAndView();
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
     PageResult pageResult = marriedService.searchMarried(married,pageNum,pageSize);
     modelAndView.addObject("pageResult",pageResult);
     modelAndView.setViewName("married");
     modelAndView.addObject("pageNum",pageNum);
     modelAndView.addObject("gourl",request.getRequestURL());
     return modelAndView;
    }

    /**
     * 搜索所有结婚信息
     * @param married
     * @param pageNum
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping("/searchAllMarried")
    @ResponseBody
    public ModelAndView searchAllMarried(Married married, Integer pageNum, Integer pageSize, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        PageResult pageResult = marriedService.searchAllMarried(married,pageNum,pageSize);
        modelAndView.setViewName("married");
        modelAndView.addObject("pageResult",pageResult);
        modelAndView.addObject("pageNum",pageNum);
        modelAndView.addObject("gourl",request.getRequestURL());
        modelAndView.addObject("married",married);

        return modelAndView;
    }

    /**
     * 通过结婚id得到结婚信息
     * @param ID
     * @return
     */
    @RequestMapping("/findMarriedByID")
    @ResponseBody
    public Result<Married> findMarriedByID(Integer ID){
        Married married = marriedService.findMarriedByID(ID);
        return new Result<>(true,"",married);
    }

    /**
     * 查看结婚证包含的居民信息
     * @param IDCard
     * @return
     */
    @RequestMapping("/findPersonByIDCard")
    @ResponseBody
    public Result<Person> findPersonByIDCard(String IDCard){
        Person person = personService.findByIDCard(IDCard);
        return new Result<>(true,"",person);
    }

    /**
     * 添加结婚信息
     * @param married
     * @return
     */
    @RequestMapping("/addMarried")
    @ResponseBody
    public Result addMarried(Married married){
        System.out.println(married);
        int result = marriedService.addMarried(married);
        if (result > 0){
            return new Result(true,"新增成功");
        }else {
            return new Result(false,"新增失败");
        }
    }

    /**
     * 判断是否已婚
     * @param IDCard
     * @return
     */
    @RequestMapping("/isMarried")
    @ResponseBody
    public Result isMarried(String IDCard){
        Married married = marriedService.isMarried(IDCard);
        MarriedFlag flag = new MarriedFlag();
        if (married == null){
            flag.setFlag(false);
            return new Result(true,"",flag);
        }else {
            flag.setFlag(true);
            return new Result(true, "", flag);
        }
    }

    /**
     * 更新结婚证信息（添加子女）
     * @param marriedID
     * @param person
     * @return
     */
    @RequestMapping("/updateMarried")
    @ResponseBody
    public Result addKid(@RequestParam("marriedID") Integer marriedID,Person person){
        String kid = person.getIDCard();
        Married married = marriedService.findMarriedByID(marriedID);
        if(married.getKid1() == null){
            married.setKid1(kid);
        }else if(married.getKid1() != null && married.getKid2() == null){
            married.setKid2(kid);
        }else if(married.getKid1() != null && married.getKid2() != null && married.getKid3() == null){
            married.setKid3(kid);
        }
        Integer result = marriedService.updateMarried(married);
        if(result>0){
            return new Result(true,"修改成功");
        }else {
            return new Result(false,"修改失败");
        }
    }

    /**
     * 判断所添加的是第几个孩子
     * @param kid
     * @return
     */
    @RequestMapping("/updateKid")
    @ResponseBody
    public Result updateKid(@RequestParam("kid") String kid){
        Married married = marriedService.SelectMarByKid(kid);
        if (married == null){
            return null;
        }else {
            if (married.getKid1() == kid) {
                married.setKid1("未登记");
            } else if (married.getKid2() == kid) {
                married.setKid2("未登记");
            } else if (married.getKid3() == kid) {
                married.setKid3("未登记");
            }
            return new Result(true,"结婚登记信息同步更新完成");
        }
    }

    /**
     * 删除结婚信息（离婚）
     * @param id
     * @return
     */
    @RequestMapping("/deleteMarried")
    @ResponseBody
    public Result deleteMarried(@RequestParam("ID")Integer id){
        Integer result = marriedService.deleteMarried(id);
        if (result > 0){
            return new Result(true,"删除成功");
        }else {
            return new Result(false,"删除失败");
        }
    }
}
