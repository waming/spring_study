package com.service.impl;

import com.dao.UserDao;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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
}
