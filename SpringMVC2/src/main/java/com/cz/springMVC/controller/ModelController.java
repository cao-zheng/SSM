package com.cz.springMVC.controller;

import com.cz.model.Address.Address;
import com.cz.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @SessionAttributes :把user实例放到Session中
 */
@Controller
@RequestMapping("/admin")
//@SessionAttributes(value = {"user"},types = {String.class})
public class ModelController {
    public static final String SUCCESS = "success";

    /**
     * 把数据添加到response的那个页面。方式1：ModelAndView
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        String viewName =SUCCESS;
        System.out.println("testModelAndView");
        ModelAndView modelAndView = new ModelAndView(viewName);
        //添加模型数据到ModelAndView
        modelAndView.addObject("time",new Date().toString());
        return modelAndView;
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        System.out.println("testMap");
        map.put("names", Arrays.asList("Tom","Java","Mick"));
        return SUCCESS;
    }
    @RequestMapping("/testModel")
    public String testModel(Model model){
        System.out.println("testModel");
        model.addAttribute("school","春花田田");
        return SUCCESS;
    }
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(User user,Map<String,User> map){
        System.out.println("testSessionAttributes");
        System.out.println(user);
        map.put("userforDb",user);
        return SUCCESS;
    }
    @ModelAttribute
    public void getUser(@RequestParam(value = "id",required = false)Integer id,Map<String,Object> map){
        if(id != null){
            Address address = new Address();
            User user = new User();
            user.setId(1);
            user.setUsername("username");
            user.setPassword("123456");
            user.setAge(1);
            user.setAddress(address);
            map.put("user",user);
        }
    }
}
