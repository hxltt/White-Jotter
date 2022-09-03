package com.whitejotter.Mapper;

import com.whitejotter.entity.User;
import com.whitejotter.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

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

    boolean modifyPassword(User user);

    UserInfo getUserInfo(String username);

    /**
     * 修改个人信息
     * @param map
     * @return
     */
    boolean modifyUserInfo(HashMap<String,Object> map);
}
