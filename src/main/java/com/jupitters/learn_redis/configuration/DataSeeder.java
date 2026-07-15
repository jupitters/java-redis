package com.jupitters.learn_redis.configuration;

import com.jupitters.learn_redis.entity.Product;
import com.jupitters.learn_redis.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataSeeder implements CommandLineRunner {
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if(productRepository.count() == 0) {
            productRepository.saveAll(List.of(
                    Product.builder()
                            .name("Mac Book Pro 14")
                            .description("Apple M3 Pro Chip, 18GB RAM")
                            .price(BigDecimal.valueOf(1999.99))
                            .stock(50)
                            .category("Electronics")
                            .build(),
                    Product.builder()
                            .name("Samsung Galaxy S25")
                            .description("256GB, 12GB RAM, Phantom Black")
                            .price(BigDecimal.valueOf(1099.99))
                            .stock(80)
                            .category("Electronics")
                            .build(),

                    Product.builder()
                            .name("Sony WH-1000XM5")
                            .description("Wireless Noise Cancelling Headphones")
                            .price(BigDecimal.valueOf(349.99))
                            .stock(120)
                            .category("Audio")
                            .build(),

                    Product.builder()
                            .name("Dell XPS 13")
                            .description("Intel Core Ultra 7, 16GB RAM, 512GB SSD")
                            .price(BigDecimal.valueOf(1499.99))
                            .stock(35)
                            .category("Computers")
                            .build(),

                    Product.builder()
                            .name("Apple iPad Air")
                            .description("11-inch, M3 Chip, 128GB Wi-Fi")
                            .price(BigDecimal.valueOf(799.99))
                            .stock(60)
                            .category("Tablets")
                            .build(),

                    Product.builder()
                            .name("Logitech MX Master 3S")
                            .description("Wireless Performance Mouse")
                            .price(BigDecimal.valueOf(99.99))
                            .stock(200)
                            .category("Accessories")
                            .build(),

                    Product.builder()
                            .name("Kindle Paperwhite")
                            .description("16GB, Waterproof, 7-inch Display")
                            .price(BigDecimal.valueOf(179.99))
                            .stock(90)
                            .category("Books & Readers")
                            .build(),

                    Product.builder()
                            .name("LG UltraGear 27")
                            .description("27-inch QHD 165Hz Gaming Monitor")
                            .price(BigDecimal.valueOf(429.99))
                            .stock(40)
                            .category("Monitors")
                            .build()
            ));
            log.info("Seeded {} products successfully!", productRepository.count());
        }
    }
}
