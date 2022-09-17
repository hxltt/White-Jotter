package com.whitejotter.service.serviceImpl;

import com.whitejotter.Mapper.UserMapper;
import com.whitejotter.entity.User;
import com.whitejotter.entity.UserInfo;
import com.whitejotter.service.UserService;
import com.whitejotter.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    /**
     * 验证用户登录
     * @return boolean
     */
    @Override
    public boolean login(String username, String password) {
        if (!userMapper.selectByName(username))
            return false;
        return userMapper.selectByNameAndPassword(username,password);
    }

    /**
     * 判断用户是否存在
     * @return boolean
     */
    @Override
    public boolean isExist(String username){
        return userMapper.selectByName(username);
    }

    /**
     * 查找该用户的盐
     * @return salt
     */
    @Override
    public String getSalt(String username){
        return userMapper.selectSalt(username);
    }

    /**
     * 新增用户
     * @return boolean
     */
    @Override
    public boolean addUser(User user,String phone){
        UserInfo userInfo = new UserInfo();
        userInfo.setPhone(Long.parseLong(phone));
        userInfo.setUsername(user.getUsername());
        userInfo.setProfilePicture(StringUtils.PROFILE_PICTURE);
        boolean result = userMapper.insertUserInfo(userInfo);
        boolean result1 = userMapper.insertUser(user);
        return result&&result1;
    }

    /**
     * 根据用户名获取用户
     * @return User
     */
        @Override
    public User selectByUserName(String username){
        return userMapper.selectByUserName(username);
    }

    /**
     * 修改密码
     * @param user
     * @return
     */
    @Override
    public boolean modifyPassword(User user) {
        return userMapper.modifyPassword(user);
    }

    @Override
    public UserInfo getUserInfo(String username) {
        return userMapper.getUserInfo(username);
    }

    @Override
    public boolean modifyUserInfo(UserInfo userInfo) {
        return userMapper.modifyUserInfo(userInfo);
    }

    @Override
    public boolean phoneIsExist(Long phone) {
        return userMapper.phoneIsExist(phone);
    }

    @Override
    public String getUsernameByphone(Long phone) {
        return userMapper.getUsernameByphone(phone) ;
    }
}
