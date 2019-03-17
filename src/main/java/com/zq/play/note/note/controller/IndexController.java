package com.zq.play.note.note.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class IndexController {
    /**
     * 初始化登录页面
     */

    @RequestMapping(value="login_view",method = RequestMethod.GET)
    private  String login_view(){
        return  "login";
    }
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    private  String index(){
        return  "index";
    }
}
