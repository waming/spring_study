package com.controller;

import com.alibaba.druid.util.StringUtils;
import com.utils.Code;
import com.utils.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    private static final Logger logger = LogManager.getLogger();

    @RequestMapping("/hello")
    public String hello(String username,  Model model) {

        Map<String, Object> map = new HashMap<String, Object>();

        if(StringUtils.isEmpty(username)) {
            map.put("code", Code.USERNAME_ERROR);
            map.put("message", Message.USERNAME_EMPTY);
        }

        System.out.println(map);
        return "index";
    }
}
