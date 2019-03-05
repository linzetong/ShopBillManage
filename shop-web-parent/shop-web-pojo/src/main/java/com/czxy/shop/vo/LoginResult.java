package com.czxy.shop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResult extends BaseResult {

    private String token;

    public LoginResult(Integer errno, String errmsg, String token) {
        super(errno, errmsg);
        this.token = token;
    }

}