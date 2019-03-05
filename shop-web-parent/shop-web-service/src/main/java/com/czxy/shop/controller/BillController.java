package com.czxy.shop.controller;

import com.czxy.shop.pojo.Bill;
import com.czxy.shop.service.BillService;
import com.czxy.shop.vo.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Author: 天子笑
 * @Date: 2019-03-05 14:38
 */
@RestController
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping("/bills")
    public ResponseEntity<BaseResult> findAllBill() {
        //调用billservice查找到所有账单信息
        List<Bill> billList = billService.findAllBill();
        System.out.println(billList);
        //返回数据
        BaseResult br = new BaseResult(0, "成功", billList);
        return ResponseEntity.ok(br);
    }

    @PostMapping("/addBill")
    public ResponseEntity<BaseResult> addBill(@RequestBody Bill bill) {
        BaseResult br = null;
        try {
            //调用billservice的添加订单方法
            billService.addBill(bill);
            br = new BaseResult(0, "成功");
        } catch (Exception e) {
            e.printStackTrace();
            br = new BaseResult(1, "添加失败");
        }
        //返回数据
        return ResponseEntity.ok(br);
    }

    @PutMapping("/updateBill")
    public ResponseEntity<BaseResult> updateBill(@RequestBody Bill bill) {
        BaseResult br = null;
        try {
            //调用billservice的修改账单方法
            billService.updateBill(bill);
            br = new BaseResult(0, "成功");
        } catch (Exception e) {
            e.printStackTrace();
            br = new BaseResult(1, "修改失败");
        }
        //返回数据
        return ResponseEntity.ok(br);
    }

    @DeleteMapping("/delBill/{id}")
    public ResponseEntity<BaseResult> updateBill(@PathVariable("id") Integer billId) {
        BaseResult br = null;
        try {
            //调用billservice的删除账单方法
            billService.deleteBill(billId);
            br = new BaseResult(0, "成功");
        } catch (Exception e) {
            e.printStackTrace();
            br = new BaseResult(1, "删除失败");
        }
        //返回数据
        return ResponseEntity.ok(br);
    }

}
