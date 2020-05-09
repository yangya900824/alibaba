package com.weico.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("/user/nacos/{id}")
    String getUserById(@PathVariable("id") Long id);
}