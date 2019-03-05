package com.czxy.shop.service;

import com.czxy.shop.dao.BillMapper;
import com.czxy.shop.pojo.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: 天子笑
 * @Date: 2019-03-05 14:37
 */
@Service
public class BillService {

    @Autowired
    private BillMapper billMapper;

    /**
     * 查找所有订单
     * @return
     */
    public List<Bill> findAllBill() {
        return billMapper.selectAll();
    }

    /**
     * 添加账单
     * @param bill
     */
    public void addBill(Bill bill) {
        //设置创建时间
        Date date = new Date();
        //格式化时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        bill.setCreateTime(time);
        billMapper.insert(bill);
    }

    /**
     * 修改账单信息
     * @param bill
     */
    public void updateBill(Bill bill) {
        billMapper.updateByPrimaryKey(bill);
    }

    /**
     * 删除账单信息
     * @param billId
     */
    public void deleteBill(Integer billId) {
        billMapper.deleteByPrimaryKey(billId);
    }
}
