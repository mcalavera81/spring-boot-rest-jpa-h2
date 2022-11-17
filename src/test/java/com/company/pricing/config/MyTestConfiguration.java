package com.company.pricing.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.pricing.loader.DataLoader;
import com.company.pricing.loader.TestDataLoader;
import com.company.pricing.repositories.BrandRepository;
import com.company.pricing.repositories.PriceRepository;
import com.company.pricing.repositories.ProductRepository;

@Configuration
public class MyTestConfiguration {


  @Bean
  @ConditionalOnProperty(name = "loadSeed", havingValue = "false")
  DataLoader dataLoaderTest(BrandRepository brandRepository, ProductRepository productRepository,
      PriceRepository priceRepository) {
    return new TestDataLoader(brandRepository, productRepository, priceRepository);
  }

}