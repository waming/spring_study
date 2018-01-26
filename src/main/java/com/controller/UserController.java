package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage/user")
public class UserController {

    @RequestMapping(value = {"", "/", "/index"})
    public String index(Model model)
    {
        model.addAttribute("message", "hello,world");
        return "master/user";
    }
}
