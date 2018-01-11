package com.controller;

import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    public @ResponseBody User doLogin(User post_user)
    {
        User userresult = userService.getUser(post_user.getUsername(), post_user.getUserpass());
        //System.out.println(userresult);




        return userresult;
    }
}
