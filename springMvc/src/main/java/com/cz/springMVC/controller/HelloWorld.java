package com.cz.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Controller :说明此类是一个控制类
 */
@Controller
public class HelloWorld {
    @RequestMapping("/helloWord")
    public String hello(){
        System.out.println("hello world");
        //返回一个视图
        return "login";
    }

    @RequestMapping("/mv")
    public ModelAndView mv(){
        System.out.println("ModelAndView");
        ModelAndView view = new ModelAndView();
        view.setViewName("helloword");
        return view;
    }
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        return "login";
    }
}
