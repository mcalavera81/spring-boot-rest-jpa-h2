package com.company.pricing.loader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.company.pricing.repositories.BrandRepository;
import com.company.pricing.repositories.PriceRepository;
import com.company.pricing.repositories.ProductRepository;

public abstract class DataLoader implements ApplicationRunner {

  protected BrandRepository brandRepository;
  protected ProductRepository productRepository;
  protected PriceRepository priceRepository;

  public DataLoader(BrandRepository brandRepository, ProductRepository productRepository,
      PriceRepository priceRepository) {
    this.brandRepository = brandRepository;
    this.productRepository = productRepository;
    this.priceRepository = priceRepository;
  }

  public void run(ApplicationArguments args) {
    persistMasterData();
  }

  abstract void persistMasterData();
}