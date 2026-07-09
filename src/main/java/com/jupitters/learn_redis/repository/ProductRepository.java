package com.jupitters.learn_redis.repository;

import com.jupitters.learn_redis.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
