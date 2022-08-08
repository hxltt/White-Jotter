package com.whitejotter.service.serviceImpl;

import com.whitejotter.Mapper.UserMapper;
import com.whitejotter.entity.User;
import com.whitejotter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean addUser(User user){
        return userMapper.insertUser(user);
    }

    /**
     * 根据用户名获取用户
     * @return User
     */
        @Override
    public User selectByUserName(String username){
        return userMapper.selectByUserName(username);
    }
}
