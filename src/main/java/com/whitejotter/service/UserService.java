package com.whitejotter.service;

import com.whitejotter.entity.User;
import com.whitejotter.entity.UserInfo;

public interface UserService {
    /**
     * 登录验证
     * @param username
     * @param password
     * @return
     */
    boolean login(String username,String password);

    /**
     * 判断用户是否存在
     * @param username
     * @return
     */
    boolean isExist(String username);

    /**
     * 根据用户名获取盐
     * @param username
     * @return
     */
    String getSalt(String username);

    /**
     * 新增用户
     * @param user
     * @return
     */
    boolean addUser(User user,String phone);

    User selectByUserName(String username);

    /**
     * 修改密码
     */
    boolean modifyPassword(User user);

    /**
     * 获取个人信息
     */
    UserInfo getUserInfo(String username);

    /**
     * 修改个人信息
     * @param userInfo
     * @param username
     * @return
     */
    boolean modifyUserInfo(UserInfo userInfo);

    /**
     * 判断电话号码是否存在
     * @param phone
     * @return
     */
    boolean phoneIsExist(Long phone);

    /**
     * 根据电话号码获取用户名
     * @param phone
     * @return
     */
    String getUsernameByphone(Long phone);
}
