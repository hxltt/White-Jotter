package com.whitejotter.Mapper;

import com.whitejotter.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 根据用户名查询用户是否存在
     * @return boolean
     */
    boolean selectByName(String name);

    /**
     * 根据用户名获取用户
     * @return User
     */
    User selectByUserName(String username);

    /**
     * 根据用户名和密码查询用户是否存在
     * @return boolean
     */
    boolean selectByNameAndPassword(@Param("name")String name,@Param("password")String password);

    /**
     * 根据用户名获取盐
     * @return boolean
     */
    String selectSalt(@Param("username") String username);

    boolean insertUser(User user);
}
