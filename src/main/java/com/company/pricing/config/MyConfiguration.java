package com.company.pricing.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.pricing.loader.DataLoader;
import com.company.pricing.loader.ProdDataLoader;
import com.company.pricing.repositories.BrandRepository;
import com.company.pricing.repositories.PriceRepository;
import com.company.pricing.repositories.ProductRepository;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
class MyConfiguration {

  @Bean
  @ConditionalOnProperty(name = "loadSeed", havingValue = "true")
  DataLoader dataLoaderProd(BrandRepository brandRepository, ProductRepository productRepository,
      PriceRepository priceRepository) {
    return new ProdDataLoader(brandRepository, productRepository, priceRepository);
  }

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("sample application API")
            .version("1.0")
            .description("Desc")
            .termsOfService("http://swagger.io/terms/")
            .license(new License().name("Apache 2.0").url("http://springdoc.org")));
  }

}