package com.xmut303.controller;

import com.sun.xml.bind.v2.model.core.ID;
import com.xmut303.entity.PageResult;
import com.xmut303.entity.Result;
import com.xmut303.pojo.Person;
import com.xmut303.pojo.Warning;
import com.xmut303.service.WarningService;
import com.xmut303.utils.AddWarningFace;
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
 * @createDate 2023/5/5 15:19
 */

@Controller
@RequestMapping("/warning")
public class WarningController {

    @Autowired
    private WarningService warningService;

    /**
     * 查询所有预警人员
     * @param person
     * @param pageNum
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping("/findWarningPeople")
    @ResponseBody
    public ModelAndView findWarningPeople(Person person,Integer pageNum, Integer pageSize, HttpServletRequest request){
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        PageResult pageResult = warningService.findWarningPeople(pageNum,pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("warning_modal");
        modelAndView.addObject("pageResult",pageResult);
        modelAndView.addObject("warning_person",person);
        modelAndView.addObject("gourl",request.getRequestURL());
        modelAndView.addObject("pageNum",pageNum);
        return modelAndView;
    }

    /**
     * 通过身份查询预警人员
     * @param IDCard
     * @return
     */
    @RequestMapping("/findWarningPeopleByID")
    @ResponseBody
    public Result<Person> findWarningPeopleByID(String IDCard){
        Person person = warningService.findWarningPeopleByID(IDCard);
        return new Result<Person>(true,"",person);
    }

    /**
     * 通过姓名查询预警人员
     * @param person
     * @param pageNum
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping("/searchWarning")
    @ResponseBody
    public ModelAndView searchWarning(Person person,Integer pageNum, Integer pageSize, HttpServletRequest request){
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        PageResult pageResult = warningService.searchWarning(person,pageNum,pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("warning_modal");
        modelAndView.addObject("pageResult",pageResult);
        modelAndView.addObject("warning",person);
        modelAndView.addObject("pageNum",pageNum);
        modelAndView.addObject("gourl",request.getRequestURL());
        return modelAndView;
    }

    /**
     * 修改预警人员
     * @param person
     * @return
     */
    @RequestMapping("/editWarning")
    @ResponseBody
    public Result editWarning(Person person){
        System.out.println("Con:"+person);
        int result = warningService.editWarning(person);
        if (result > 0){
            return new Result(true,"预警人员信息修改成功");
        }else {
            return new Result(false,"预警人员信息修改失败");
        }
    }

    /**
     * 删除预警人员
     * @param IDCard
     * @return
     */
    @RequestMapping("/delWarning")
    @ResponseBody
    public Result delWarning(String IDCard){
        int result = warningService.delWarning(IDCard);
        if (result > 0){
            return new Result(true,"预警人员移除成功");
        }else {
            return new Result(false,"预警人员移除失败");
        }
    }

    /**
     * 添加预警人员
     * @param person
     * @return
     * @throws Exception
     */
    @RequestMapping("/addWarning")
    @ResponseBody
    public Result addWarning(Person person) throws Exception {
        int lastIndex = person.getPhoto_url().lastIndexOf("\\");
        String url = "";
        if(lastIndex>0){
           url  = "src/main/webapp/img/"+person.getPhoto_url().substring(lastIndex+1);
        }else {

            url = "src/main/webapp/img/"+person.getPhoto_url().substring(person.getPhoto_url().lastIndexOf("/")+1);
        }

        String IDCard = person.getIDCard();
        String type = person.getWarn_type();
        String name = person.getName();
        Warning warning = new Warning();
        warning.setPID(IDCard);
        warning.setWarn_type(type);
        System.out.println(warning);
        AddWarningFace.AddEntityAndFace(IDCard,url,name);
        int result = warningService.addWarning(warning);
        if(result > 0){
            return new Result(true,"添加成功");
        }else {
            return new Result(false,"添加失败");
        }
    }

    /**
     * 从居民信息添加预警人员
     * @param url
     * @param name
     * @param PID
     * @param type
     * @return
     * @throws Exception
     */
    @RequestMapping("/addWarningByPerson")
    @ResponseBody
    public Result addWarningByPerson(@RequestParam("url")String url,@RequestParam("name")String name,
                                     @RequestParam("PID")String PID,@RequestParam("type")String type) throws Exception {
        url = "src/main/webapp/img/"+url.substring(url.lastIndexOf("/"));
        Warning warning = new Warning();
        warning.setWarn_type(type);
        warning.setPID(PID);
        AddWarningFace.AddEntityAndFace(PID,url,name);
        int result = warningService.addWarning(warning);
        if(result > 0){
            return new Result(true,"添加成功");
        }else {
            return new Result(false,"添加失败");
        }
    }
}
