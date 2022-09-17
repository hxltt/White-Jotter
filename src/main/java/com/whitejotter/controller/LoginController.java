package com.whitejotter.controller;

import com.whitejotter.entity.User;
import com.whitejotter.result.ResultFactory;
import com.whitejotter.service.UserService;
import com.whitejotter.result.Result;
import com.whitejotter.util.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class LoginController {
    Logger logger = LoggerFactory.getLogger(LibraryController.class);

    @Autowired
    UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 登出功能
     * @return Result
     */
    @GetMapping("api/logout")
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        String message = "已退出账号！";
        return ResultFactory.buildSuccessResult(message);
    }

    @GetMapping(value = "api/authentication")
    public String authentication(){
        return "身份认证成功";
    }


    /**
     *登录验证
     * @return Result
     */
    @PostMapping(value = "/api/login")
    public Result login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        Subject subject = SecurityUtils.getSubject();
//        subject.getSession().setTimeout(10000);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
        usernamePasswordToken.setRememberMe(true);
        try {
            logger.info("login"+username);
            subject.login(usernamePasswordToken);
            Result result = ResultFactory.buildSuccessResult(username);
            logger.info("result:"+result.toString());
            return result;
        } catch (AuthenticationException e) {
            String message = "账号密码错误";
            return ResultFactory.buildFailResult(message);
        }
    }

    /**
     * 手机号登录
     * @return Result
     */
    @PostMapping(value = "/api/phoneLogin")
    public Result phonelogin(@RequestBody Map<String,Object> map) {
        Long phone = Long.parseLong((String) map.get("phone"));
        // 判断电话号码是否存在
        if (!userService.phoneIsExist(phone)){
            return ResultFactory.buildFailResult("该电话号未注册");
        }
        String verificationCode = (String) map.get("verificationCode");
        try {
            String code = (String) redisTemplate.opsForValue().get(phone + "VerificationCode");
            if(code!=null){
                if (code.equals(verificationCode)){
                    // 删除redis里的验证码
                    redisTemplate.opsForHash().delete(phone + "VerificationCode");
                    String username = userService.getUsernameByphone(phone);
                    Subject subject = SecurityUtils.getSubject();
//        subject.getSession().setTimeout(10000);
                    UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, "123456789");
                    usernamePasswordToken.setRememberMe(true);
                    subject.login(usernamePasswordToken);
                    return ResultFactory.buildSuccessResult(username);
                }else {
                    return ResultFactory.buildFailResult("验证码错误");
                }
            }
            else {
                return ResultFactory.buildFailResult("验证码已失效或不存在");
            }
        } catch (Exception e) {
            logger.error(e.toString());
            return ResultFactory.buildResult(500,"错误","error");
        }
    }

    /**
     * 注册功能
     * @return Result
     */
    @PostMapping(value ="/api/register")
    public Result register(@RequestBody Map<String,Object> map) {
        // 判断电话号码是否存在
        if (userService.phoneIsExist(Long.parseLong((String) map.get("phone")))){
            return ResultFactory.buildFailResult("电话号码已被注册");
        }
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        username = HtmlUtils.htmlEscape(username);
        User user = new User();
        user.setUsername(username);
        // 判断用户名是否存在
        boolean exist = userService.isExist(username);
        if (exist) {
            String message = "用户名已被使用";
            return ResultFactory.buildFailResult(message);
        }
        // 生成盐,默认长度 16 位
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        // 设置 hash 算法迭代次数
        int times = 2;
        // 得到 hash 后的密码
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();
        // 存储用户信息，包括 salt 与 hash 后的密码
        user.setSalt(salt);
        user.setPassword(encodedPassword);
        try {
            userService.addUser(user,(String) map.get("phone"));
            return ResultFactory.buildSuccessResult(user);
        } catch (Exception e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return ResultFactory.buildFailResult("注册失败");
    }


    /**
     * 生成验证码
     * @param phone
     * @return
     */
    @GetMapping("/api/verificationCode")
    public Result verificationCode(@RequestParam("phone")String phone){
        try {
            if(redisTemplate.opsForValue().get(phone+"VerificationCode")==null){
                String code = StringUtils.getRandomString(4);
                redisTemplate.opsForValue().set(phone+"VerificationCode", code,60, TimeUnit.SECONDS);
                return ResultFactory.buildSuccessResult(code);
            }
            else {
                return ResultFactory.buildFailResult("验证码在有效期中");
            }
        } catch (Exception e) {
            logger.error(e.toString());
            return ResultFactory.buildFailResult("获取验证码失败");
        }
    }

    /**
     * 验证验证码
     * @param phone
     * @param verificationCode
     * @return
     */
    @PostMapping("/api/verificationCode")
    public Result verifyCode(@RequestParam("phone")String phone, @RequestParam("verificationCode")String verificationCode ){
        try {
            String code = (String) redisTemplate.opsForValue().get(phone + "VerificationCode");
            if(code!=null){
                if (code.equals(verificationCode)){
                    return ResultFactory.buildSuccessResult("正确");
                }else {
                    return ResultFactory.buildFailResult("验证码错误");
                }
            }
            else {
                return ResultFactory.buildFailResult("验证码已失效或不存在");
            }
        } catch (Exception e) {
            logger.error(e.toString());
            return ResultFactory.buildResult(500,"错误","error");
        }
    }


}
