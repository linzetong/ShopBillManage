package com.czxy.shop.service;

import com.czxy.shop.dao.UserMapper;
import com.czxy.shop.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @Author: 天子笑
 * @Date: 2019-03-05 9:48
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findByUsername(String username,String password) {
        //根据用户名查找用户
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("username",username)
                                .andEqualTo("password",password);
        User user = userMapper.selectOneByExample(example);
        //返回查找到的用户
        return user;
    }

}
