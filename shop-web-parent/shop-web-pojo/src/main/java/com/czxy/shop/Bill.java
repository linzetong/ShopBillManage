package com.czxy.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * @Author: 天子笑
 * @Date: 2019-02-25 17:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {

    @Id
    @Column(name = "bill_id")
    private Integer billId;

    @Column(name = "productName")
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
    private Timestamp createTime;

}
