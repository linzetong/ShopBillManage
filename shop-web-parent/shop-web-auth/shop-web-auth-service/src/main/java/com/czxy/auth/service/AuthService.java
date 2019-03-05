package com.czxy.auth.service;

import com.czxy.auth.client.UserClient;
import com.czxy.shop.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserClient userClient;


    public User findUserByUsername(User user){
        ResponseEntity<User> entity = this.userClient.findUserByUsername(user.getUsername(), user.getPassword());
        User body = entity.getBody();
        return body;
    }


}