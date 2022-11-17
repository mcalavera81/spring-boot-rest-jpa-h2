package com.company.pricing.loader;

import java.time.LocalDateTime;
import java.util.List;

import com.company.pricing.domain.Brand;
import com.company.pricing.domain.Currency;
import com.company.pricing.domain.Price;
import com.company.pricing.domain.Product;
import com.company.pricing.repositories.BrandRepository;
import com.company.pricing.repositories.PriceRepository;
import com.company.pricing.repositories.ProductRepository;

public class TestDataLoader extends DataLoader{

  public TestDataLoader(BrandRepository brandRepository, ProductRepository productRepository,
      PriceRepository priceRepository) {
    super(brandRepository, productRepository, priceRepository);
  }

  @Override
  void persistMasterData(){
    Brand zara = brandRepository.save(new Brand("ZARA"));
    Product dummyProduct = productRepository.save(new Product(35455, "Dummy Product"));

    priceRepository.saveAll(List.of(
        new Price(1L, zara, dummyProduct, LocalDateTime.parse("2020-06-14T00:00:00"),
            LocalDateTime.parse("2020-12-31T23:59:59"), 0, 3550, Currency.EUR),
        new Price(2L, zara, dummyProduct, LocalDateTime.parse("2020-06-14T15:00:00"),
            LocalDateTime.parse("2020-06-14T18:30:00"), 1, 2545, Currency.EUR),
        new Price(3L, zara, dummyProduct, LocalDateTime.parse("2020-06-15T00:00:00"),
            LocalDateTime.parse("2020-06-15T11:00:00"), 1, 3050, Currency.EUR),
        new Price(4L, zara, dummyProduct, LocalDateTime.parse("2020-06-15T16:00:00"),
            LocalDateTime.parse("2020-12-31T23:59:59"), 1, 3895, Currency.EUR)
    ));
  }

}
