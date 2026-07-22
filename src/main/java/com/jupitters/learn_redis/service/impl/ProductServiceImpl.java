package com.jupitters.learn_redis.service.impl;

import com.jupitters.learn_redis.dto.ProductRequest;
import com.jupitters.learn_redis.entity.Product;
import com.jupitters.learn_redis.repository.ProductRepository;
import com.jupitters.learn_redis.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts(){
        log.info(">>> fetching ALL products from DATABASE");
        simulateSlowDbCall();
        return productRepository.findAll();
    }

    @Cacheable(value = "products", key = "#id")
    public Product getProductById(Long id) {
        log.info(">>> fetching product [{}] from DATABASE", id);
        simulateSlowDbCall();
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found!"));
    }

    public Product createProduct(ProductRequest request) {
        log.info(">>> creating new product: {}", request.getName());
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .stock(request.getStock())
                .category(request.getCategory())
                .build();
        return productRepository.save(product);
    }

    @CachePut(value = "products", key = "#id")
    public Product updateProduct(Long productId, ProductRequest request) {
        log.info(">>> updating product [{}] in DATABASE", productId);
        Product existing = getProductById(productId);
        existing.setName(request.getName());
        existing.setDescription(request.getDescription());
        existing.setPrice(request.getPrice());
        existing.setStock(request.getStock());
        existing.setCategory(request.getCategory());

        return productRepository.save(existing);
    }

    public void deleteProduct(Long productId){
        log.info(">>> deleting product [{}] from DATABASE", productId);
        productRepository.deleteById(productId);
    }

    private void simulateSlowDbCall() {
        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
