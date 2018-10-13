package com.springdemo.dao;

import com.springdemo.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);
    
}
