package com.weico.controller;

//PaymentController

import com.weico.entity.CommonResult;
import com.weico.entity.Product;
import com.weico.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    //只传给前端CommonResult，不需要前端了解其他的组件
    @PostMapping(value = "/product/create")
    public CommonResult create(Product user) {

        log.info("*****插入结果：" + user);
        return new CommonResult(200, "插入数据成功", user);
    }

    @GetMapping(value = "/product/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Product user = new Product(id, "yangya");//paymentService.getPaymentById(id);
        log.info("*****插入结果：" + user);
        if (user != null) {
            return new CommonResult(200, "查询成功", productService.getProductById(id+""));
        } else {
            return new CommonResult(444, "没有对应记录,查询ID：" + id, null);
        }
    }

    @GetMapping(value = "/product2/get/{id}")
    public CommonResult getPaymentByIdHys(@PathVariable("id") Long id) {
        Product user = new Product(id, "yangya");//paymentService.getPaymentById(id);
        log.info("*****插入结果：" + user);
        if (user != null) {
            return new CommonResult(200, "查询成功", productService.getProductByIdHre(id+""));
        } else {
            return new CommonResult(444, "没有对应记录,查询ID：" + id, null);
        }
    }
}
