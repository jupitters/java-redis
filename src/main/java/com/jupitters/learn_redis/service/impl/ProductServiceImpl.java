package com.jupitters.learn_redis.service.impl;

import com.jupitters.learn_redis.entity.Product;
import com.jupitters.learn_redis.repository.ProductRepository;
import com.jupitters.learn_redis.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
