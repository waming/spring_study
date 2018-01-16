package com.controller;

import com.alibaba.druid.util.StringUtils;
import com.entity.User;
import com.service.UserService;
import com.utils.Code;
import com.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    //登陆页面
    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }

    //确认登陆
    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> doLogin(String username, String userpass, HttpSession httpSession)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("message", "ok");

        if (StringUtils.isEmpty(username)) {
            map.put("code", Code.USERNAME_ERROR);
            map.put("message", Message.USERNAME_EMPTY);
            return map;
        }

        if (StringUtils.isEmpty(userpass)) {
            map.put("code", Code.USERPASS_ERROR);
            map.put("message", Message.USERPASS_EMPTY);
            return map;
        }

        User user = userService.getUser(username, userpass);

        if (user != null) {
            httpSession.setAttribute("username", username);
        } else {
            map.put("code", Code.SYSTEM_FALI);
            map.put("message", Message.SYSTEM_FALI);
        }

        return map;
    }
}
