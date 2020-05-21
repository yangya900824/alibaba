package com.weico.fegin;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public String getUserById(Long id) {
        return "用户服务降级了";
    }
}