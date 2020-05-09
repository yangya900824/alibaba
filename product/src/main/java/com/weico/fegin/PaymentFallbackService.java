package com.weico.fegin;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public String getUserById(Long id) {
        return "null";
    }
}