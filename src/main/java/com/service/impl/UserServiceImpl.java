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
import java.util.Map;

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

    public List<User> getlist(Map<String, String> map) {

        /* 日期搜索 */
        if (map.get("start_time") != null) {
            map.put("start_time", Utils.dateToTimestamp(map.get("start_time")));
        }

        List<User> users =  userDao.getlist(map);
        if (users!= null){

            for (User u:users) {
                u.setCreate_time(Utils.timestampToStringDate(u.getCreate_time(), 1));
            }
        }

        return users;
    }
}
