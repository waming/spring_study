package com.service;

import com.entity.User;

public interface UserService {

    public User getUser(long userId);
    public User getUser(String username, String userpass);
    public String setUser();
}
