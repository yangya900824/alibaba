package com.weico.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.weico.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
    int i = 0;
    @Override
    @SentinelResource(value = "getProductById",blockHandler = "exceptionHandler")
    public String getProductById(String id) {
        return id;
    }

    // 限流与阻塞处理
    public String exceptionHandler(String id, BlockException ex) {
        log.error( "blockHandler：" + id, ex);
        return "blockHandler：" + id;
    }

    @Override
    @SentinelResource(value = "getProductByIdHre")
    public String getProductByIdHre(String id) {
        i++;
        if(i>3){
            throw new RuntimeException("222");
        }
        return "降级：" + id;
    }
}
