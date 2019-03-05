package com.czxy.auth.client;

import com.czxy.shop.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "bill-service",fallback = UserClientFallback.class)
public interface UserClient {

    @GetMapping("query")
    public ResponseEntity<User> findUserByUsername(@RequestParam("username") String username, @RequestParam("password") String password);

}