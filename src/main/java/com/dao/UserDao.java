package com.dao;

import com.entity.User;

public interface UserDao {
    public User getInfoById(long userId);
    public User userLogin(String username, String userpass);
}
