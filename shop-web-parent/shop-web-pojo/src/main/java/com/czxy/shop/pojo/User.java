package com.czxy.shop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;

/**
 * @Author: 天子笑
 * @Date: 2019-03-05 9:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    private Integer uid;
    private String username;
    private String password;
}
