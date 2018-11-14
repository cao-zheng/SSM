package com.cz.action;

import com.cz.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserAction {
    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping("/view")
    public String view(){
        return "view";
    }
}
