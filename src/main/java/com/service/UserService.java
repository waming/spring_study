package com.service;

import com.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    public User getUser(long userId);
    public User getUser(String username, String userpass);
    public String setUser();
    public List<User> getlist(Map<String, String> map);
}
