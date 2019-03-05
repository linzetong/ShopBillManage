package com.czxy.auth.client;

import com.czxy.shop.pojo.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {

    @Override
    public ResponseEntity<User> findUserByUsername(String username, String password) {
        User user = new User();
        user.setUid(-100);

        return ResponseEntity.ok(user);
    }
}