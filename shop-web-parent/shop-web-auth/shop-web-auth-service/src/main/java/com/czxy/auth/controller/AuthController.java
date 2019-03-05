package com.czxy.auth.controller;

import com.czxy.auth.entity.JwtProperties;
import com.czxy.auth.entity.UserInfo;
import com.czxy.auth.service.AuthService;
import com.czxy.auth.util.JwtUtils;
import com.czxy.shop.pojo.User;
import com.czxy.shop.vo.BaseResult;
import com.czxy.shop.vo.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping("login")
    public ResponseEntity<Object> login(@RequestBody User user){
        // 1. 调用Service，查找用户信息
        User dbUser = authService.findUserByUsername(user);
        // 2. 如果找不到用户信息，直接报错
        //    dbUser.getId()==-100 触发了熔断
        if(dbUser == null || dbUser.getUid()==-100){
            BaseResult br = new BaseResult(1, "未找到用户信息");
            return ResponseEntity.ok(br);
        }
        // 3. 如果找到了用户信息，生成jwt，
        //    第一个参数：userInfo
        //    第二个参数：私钥
        //    第三个参数：存活时间
        UserInfo userInfo = new UserInfo(dbUser.getUid(), dbUser.getUsername());

        String token = null;
        try {
            token = JwtUtils.generateToken(userInfo, jwtProperties.getPrivateKey(), 30);
        } catch (Exception e) {
            e.printStackTrace();
            BaseResult br = new BaseResult(1, "服务器异常");
            return ResponseEntity.ok(br);
        }

        // 4. 根据接口拼接返回结果，返回数据
        LoginResult lr = new LoginResult(0, "成功", token);

        return ResponseEntity.ok(lr);
    }


}