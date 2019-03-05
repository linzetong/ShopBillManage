package com.czxy.shop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: 天子笑
 * @Date: 2019-03-05 9:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResult {

    private Integer errno;
    private String errmsg;
    private Object data;

    public BaseResult(Integer errno, String errmsg) {
        this.errno = errno;
        this.errmsg = errmsg;
    }
}
