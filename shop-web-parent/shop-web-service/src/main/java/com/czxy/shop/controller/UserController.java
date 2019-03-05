package com.czxy.shop.controller;

import com.czxy.shop.pojo.User;
import com.czxy.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 天子笑
 * @Date: 2019-03-05 9:46
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查找用户
     * @param username
     * @param password
     * @return
     */
    @GetMapping("query")
    public ResponseEntity<Object> queryUser(@RequestParam("username") String username, @RequestParam("password") String password){
        User user = userService.findByUsername(username,password);
        return ResponseEntity.ok(user);
    }
}
