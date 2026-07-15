package com.jupitters.learn_redis.service;

import com.jupitters.learn_redis.dto.ProductRequest;
import com.jupitters.learn_redis.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(ProductRequest request);
    Product updateProduct(Long productId, ProductRequest request);
    void deleteProduct(Long productId);
}
