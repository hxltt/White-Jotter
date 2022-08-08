package com.whitejotter.service;

import com.whitejotter.entity.User;

public interface UserService {
    boolean login(String username,String password);

    boolean isExist(String username);

    String getSalt(String username);

    boolean addUser(User user);

    User selectByUserName(String username);
}
