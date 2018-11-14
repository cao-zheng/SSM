package com.cz.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    /**
     *redirect:/index.jsp 绝对路径和相对路径问题，有"/"从webcontext开始
     *没有"/",就是从当前路径去找。
     */
    @RequestMapping("/testRedirect1")
    public String testRedirect1(){
        System.out.println("testRedirect1");
        return "redirect:/testRedirect2";
    }
    @RequestMapping("/testRedirect2")
    public String testRedirect2(){
        System.out.println("testRedirect2");
        return "redirect:/admin/testSessionAttributes";
    }
}
