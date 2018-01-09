package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/index")
    public String index(Model model)
    {
        model.addAttribute("message", "hello,world");
        return "main";
    }

}
