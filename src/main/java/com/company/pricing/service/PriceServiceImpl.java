package com.company.pricing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.pricing.domain.Price;
import com.company.pricing.dto.PriceGetRequest;
import com.company.pricing.exceptions.BrandNotFoundException;
import com.company.pricing.exceptions.ProductNotFoundException;
import com.company.pricing.repositories.BrandRepository;
import com.company.pricing.repositories.PriceRepository;
import com.company.pricing.repositories.ProductRepository;

import lombok.val;

@Service
public class PriceServiceImpl implements PriceService {

  private PriceRepository priceRepository;
  private BrandRepository brandRepository;
  private ProductRepository productRepository;

  public PriceServiceImpl(
      BrandRepository brandRepository,
      ProductRepository productRepository,
      PriceRepository priceRepository) {
    this.brandRepository = brandRepository;
    this.productRepository = productRepository;
    this.priceRepository = priceRepository;
  }

  @Override
  public Optional<Price> findPrice(PriceGetRequest req) throws BrandNotFoundException, ProductNotFoundException {

    val brand = brandRepository.findByName(req.getBrand()).orElseThrow(()->new BrandNotFoundException(req.getBrand()));
    val product = productRepository.findById(req.getProductId()).orElseThrow(()->new ProductNotFoundException(req.getProductId()));
    val prices = priceRepository.findByOrderByPriorityDesc(brand, product, req.getDateTime());
    if(prices.isEmpty()) return Optional.empty();
    return Optional.of(prices.get(0));
  }
}
