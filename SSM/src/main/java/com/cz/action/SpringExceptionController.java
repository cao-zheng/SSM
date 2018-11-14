package com.cz.action;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SpringExceptionController {
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
