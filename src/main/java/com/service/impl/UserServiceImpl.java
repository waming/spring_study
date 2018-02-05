package com.service.impl;

import com.dao.UserDao;
import com.entity.User;
import com.service.UserService;
import com.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUser(long userId) {
        return userDao.getInfoById(userId);
    }

    public String setUser() {
        return "hello，小明";
    }

    public User getUser(String username, String userpass) {
        return userDao.userLogin(username, DigestUtils.md5DigestAsHex(userpass.getBytes()));
    }

    public List<User> getlist(Integer limit, Integer offset) {

        List<User> users =  userDao.getlist(limit, offset);
        if (users!= null){

            for (User user:users) {
                user.setCreate_time(Utils.timestampToStringDate(user.getCreate_time(), 1));
            }
        }

        return users;
    }
}
