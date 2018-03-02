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
import java.util.Map;

@Controller
@RequestMapping("/manage/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"", "/", "/index"})
    public String index(
            @RequestParam Map<String, Object>map,
            Model model)
    {
        List<User> lists = userService.getlist(map);
        model.addAttribute("users", lists);
        return "master/user";
    }
}
