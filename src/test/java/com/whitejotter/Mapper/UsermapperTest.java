package com.whitejotter.Mapper;

import com.whitejotter.entity.User;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsermapperTest {
    @Autowired
    UserMapper usermapper;


    @Test
    void  selectByNameTest(){
        System.out.println(usermapper.selectByName("HX"));
        System.out.println(usermapper.selectByName("hx"));
    }

    @Test
    void  selectByNameAndPasswordTest(){
        usermapper.selectByNameAndPassword("hx","1");
    }


    @Test
    void selectSalt(){
        System.out.println(usermapper.selectSalt("hx"));
    }

    @Test
    void insertUser(){
        System.out.println(usermapper.insertUser(new User("lt1","dsad","sda")));
    }

    @Test
    void selectByUserName(){
        System.out.println(usermapper.selectByUserName("hx").toString());
    }



}
