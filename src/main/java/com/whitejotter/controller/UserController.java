package com.whitejotter.controller;

import com.whitejotter.entity.User;
import com.whitejotter.entity.UserInfo;
import com.whitejotter.result.Result;
import com.whitejotter.result.ResultFactory;
import com.whitejotter.service.UserService;
import com.whitejotter.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 修改密码
     * @param map
     * @return
     */
    @PostMapping("/api/modifyPassword")
    public Result changePassword(@RequestBody Map<String,Object> map){
        try {
            User user = new User();
            user.setPassword((String) map.get("password"));
            user.setUsername((String) map.get("username"));
            user.setSalt(userService.getSalt(user.getUsername()));
            //判断密码是否相同
            User encryption = StringUtils.encryption(user);
            boolean exist = userService.login(encryption.getUsername(), encryption.getPassword());
            if(!exist){
                log.info(String.valueOf("原密码错误"));
                return ResultFactory.buildFailResult("原密码错误");
            }else {
                user.setSalt(null);
                user.setPassword((String) map.get("newPassword"));
                user = StringUtils.encryption(user);
                userService.modifyPassword(user);
                log.info(String.valueOf("修改密码成功"));
                return ResultFactory.buildSuccessResult("修改密码成功");
            }
        } catch (Exception e){
            log.info(String.valueOf("修改密码失败"));
            return ResultFactory.buildFailResult("修改密码失败");
        }
    }

    /**
     * 获取用户信息
     * @param username
     * @return
     */
    @GetMapping("api/userInfo")
    public Result userInfo(@RequestParam("username") String username){
        try {
            return ResultFactory.buildSuccessResult(userService.getUserInfo(username));
        }catch (Exception e){
            log.info("获取个人信息失败");
            return ResultFactory.buildFailResult("获取个人信息失败");
        }
    }

    /**
     * 改个人信息
     * @param userInfo
     * @return
     */
    @PostMapping("api/userInfo")
    public Result modifyUserInfo(@RequestBody UserInfo userInfo){
        try {
            if (userService.modifyUserInfo(userInfo)){
                log.info("更改个人信息成功!");
                return ResultFactory.buildSuccessResult("更改个人信息成功！");
            }
            else {
                log.info("更改个人信息失败!");
                return ResultFactory.buildFailResult("更改个人信息失败!");
            }
        }catch (Exception e){
            log.info("更改个人信息失败!");
            log.info(e.toString());
            return ResultFactory.buildFailResult("更改个人信息失败!");
        }
    }

//    @PostMapping("api/userInfo1")
//    public void modifyUserInfo(@RequestBody UserInfo userinfo){
//        log.info(userinfo.toString());
//    }
}
