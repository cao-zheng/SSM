package com.cz.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/throw")
public class ExceptionController{
    @RequestMapping("/test")
    public String testThrow(@RequestParam(value = "i",required = false,defaultValue = "1") int i){
            int t = 10/i;
            if(i == 2){
                throw new RuntimeException();
            }
        return "../success";
    }
    @ExceptionHandler({ArithmeticException.class})
    public String ExceptionHandle(Exception e,Model model){
        model.addAttribute("ex","1"+e);
        return "../springError";
    }
    @ExceptionHandler({RuntimeException.class})
    public ModelAndView handlerRuntimeException(Exception e){
        System.out.println("出异常了  RuntimeException  :  " + e);
        ModelAndView mv = new ModelAndView("../springError");
        mv.addObject("ex", "2"+e);
        return mv;
    }
}
