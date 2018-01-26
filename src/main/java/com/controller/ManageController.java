package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage")
public class ManageController {

    @RequestMapping(value = {"", "/", "/index"})
    public String index(Model model)
    {
        return "master/main";
    }
}
