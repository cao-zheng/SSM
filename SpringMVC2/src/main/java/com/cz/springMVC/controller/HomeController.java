package com.cz.springMVC.controller;

import com.cz.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@Controller
@RequestMapping("/HomeController")
public class HomeController {

    public static final String SUCCESS = "success";

    /**
     * 提供了初始的映射信息，修饰到类的时候，根据url分类，模板之间分类
     * @return
     */
    @RequestMapping("/testRequestMapping")
    public String testRequestMapping(){
        return SUCCESS;
    }

    @RequestMapping(value = "/testAntPath",method = RequestMethod.GET,params = {"username=admin","password=1"},headers = {"Accept-Language=zh-CN,zh;q=0.8"})
    public String testAntPath(HttpServletRequest request){
        System.out.println("testAntPath" + request.getParameter("username"));
        return SUCCESS;
    }

    /**
     * 支持restful风格
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id")String id){
        System.out.println(id);
        return SUCCESS;
    }

    /**
     * @RequestParam来映射参数，value即参数名
     * required=false ：表示这个参数可以不变
     * 如果为true时，该参数必须要传，默认是true
     * defaultValue: 请求参数没传值时默认值
     * @param un
     * @param password
     * @return
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(value = "username")String un,
                                   @RequestParam(value = "password",required = false,defaultValue = "0")String password){
        System.out.println("username: " + un);
        System.out.println("password:" + password);
        return SUCCESS;
    }
    /**
     *请求头部信息
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept-Language")String lang){
        System.out.println("testRequestHeader:" + lang);
        return SUCCESS;
    }
    /**
     *请求Cookies信息
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID")String sessionId){
        System.out.println("testCookieValue:" + sessionId);
        return SUCCESS;
    }
    /**
     *请求POJO对象
     */
    @RequestMapping(value="/testPOJO",method = RequestMethod.POST)
    public String testPOJO(User user){
        System.out.println("testPOJO:" + user);
        return SUCCESS;
    }
    /**
     *ServletAPI
     */
    @RequestMapping(value="/testServletAPI")
    public void testServletAPI(HttpServletRequest request, HttpServletResponse response,Writer out) throws IOException {
        System.out.println("ServletAPI");
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("age"));
        //response.getWriter().write("hello");
        out.write("hello");
    }
}
