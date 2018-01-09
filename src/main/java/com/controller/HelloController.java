package com.controller;

import com.entity.User;
import com.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class HelloController {

    public HelloController() {
        System.out.println("启动");
    }

    @Autowired
    private UserService userService;

    private static final Logger logger = LogManager.getLogger();

    @RequestMapping("/hello")
    public String hello(String username, Model model) {
        model.addAttribute("username", username);
        System.out.println(userService.setUser());
        logger.info("请求登录");
        logger.debug("debug");
        logger.warn("warn");
        return "index";
    }

    @RequestMapping(value = "/go", method = RequestMethod.POST)
    public String testPost()
    {
        System.out.println("test post");

        long id = 1002;
        User user = userService.getUser(id);
        System.out.println(user);
        return "test";
    }

    //登陆界面
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, HttpSession httpsession)
    {
        User userresult = userService.getUser(user.getUsername(), user.getUserpass());
        if(userresult != null){

            httpsession.setAttribute("username", user.getUsername());
            return "redirect:/user/index";
        }else{
            return "redirect:/login.jsp";
        }
    }
}
