package com.controller;

import com.entity.User;
import com.service.UserService;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/manage/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"", "/", "/index"})
    public String index(
            @RequestParam(required = false, defaultValue = "0") Integer limit,
            @RequestParam(required = false, defaultValue = "10") Integer offset,
            Model model)
    {
        List<User> lists = userService.getlist(limit, offset);
        model.addAttribute("users", lists);
        return "master/user";
    }
}
