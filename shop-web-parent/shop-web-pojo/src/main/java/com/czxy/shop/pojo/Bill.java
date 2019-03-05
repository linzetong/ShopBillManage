package com.czxy.shop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author: 天子笑
 * @Date: 2019-02-25 17:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bill {

    @Id
    @Column(name = "bill_id")
    private Integer billId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "provider_name")
    private String providerName;

    @Column(name = "product_count")
    private Integer productCount;

    @Column(name = "product_price")
    private Double productPrice;

    @Column(name = "is_pay")
    private Integer isPay;

    @Column(name = "create_time")
    private String createTime;

}
