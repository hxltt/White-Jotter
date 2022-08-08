package com.whitejotter.service;

import com.whitejotter.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void login(){
        System.out.println(userService.login("hxh","123456000"));
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        System.out.println(userService.login("hx","123456000"));
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        System.out.println(userService.login("hx","123"));

    }

    @Test
    void isExist(){
        System.out.println(userService.isExist("hx"));
    }

    @Test
    void addUser(){
        System.out.println(userService.addUser(new User("hx1","awdead","ds")));
    }

    @Test
    void getSalt(){
        System.out.println(userService.getSalt("hx1"));
    }

    @Test
    void selectByUserName(){
        System.out.println(userService.selectByUserName("hx").toString());
    }
}
