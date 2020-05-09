package com.weico.controller;

//PaymentController

import com.weico.entity.CommonResult;
import com.weico.entity.Product;
import com.weico.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ProductRestController {


    private static final String USER_URL="http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<User> create(@RequestBody Product payment){
        return restTemplate.postForObject(USER_URL+"/user/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Product> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(USER_URL+"/user/get/"+id,CommonResult.class);
    }

    /*//只传给前端CommonResult，不需要前端了解其他的组件
    @PostMapping(value = "/product/rest/create")
    public CommonResult create(Product user) {

        log.info("*****插入结果：" + user);
        return new CommonResult(200, "插入数据成功", user);
    }

    @GetMapping(value = "/product/rest/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Product user = new Product(id, "yangya");//paymentService.getPaymentById(id);
        log.info("*****插入结果：" + user);
        if (user != null) {
            return new CommonResult(200, "查询成功", user);
        } else {
            return new CommonResult(444, "没有对应记录,查询ID：" + id, null);
        }
    }*/
}
