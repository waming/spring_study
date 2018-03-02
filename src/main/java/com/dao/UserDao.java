package com.dao;

import com.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public User getInfoById(long userId);
    public User userLogin(String username, String userpass);
    public List<User> getlist(@Param(value = "map") Map<String, Object> map);
}