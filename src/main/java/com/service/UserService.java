package com.service;

import com.entity.User;

import java.util.List;

public interface UserService {

    public User getUser(long userId);
    public User getUser(String username, String userpass);
    public String setUser();
    public List<User> getlist(Integer limit, Integer offset);
}
