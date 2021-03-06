package com.weico.controller;

//PaymentController

import com.weico.entity.CommonResult;
import com.weico.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class UserController {

    //只传给前端CommonResult，不需要前端了解其他的组件
    @PostMapping(value = "/user/create")
    public CommonResult create(User user) {

        log.info("*****插入结果：" + user);
        return new CommonResult(200, "插入数据成功", user);
    }

    @GetMapping(value = "/user/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        User user = new User(id, "yangya");//paymentService.getPaymentById(id);
        log.info("*****插入结果：" + user);
        if (user != null) {
            return new CommonResult(200, "查询成功", user);
        } else {
            return new CommonResult(444, "没有对应记录,查询ID：" + id, null);
        }
    }
}
