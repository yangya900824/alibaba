package com.weico.controller;

import com.weico.fegin.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
@RestController
@RequestMapping("/nacos")
public class ProductNacosController {
    /*
    因为在yml中配置了service-url.nacos-user-service，
    这里不需要再定义要访问微服务名常量，而是通过boot直接读出来
     */

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/{id}")
    public String paymentInfo(@PathVariable("id") Long id){
        return restTemplate.getForObject(serverURL+"/user/nacos/"+id,String.class);
    }

/*    @GetMapping("/fegin/product/{id}")
    public String product(@PathVariable("id") Long id){
        return userClient.getUserById(id);
    }*/

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/fegin/{id}")
    public String paymentSQL(@PathVariable("id") Long id){
        return paymentService.getUserById(id);
    }
}