package com.company.pricing.service;

import java.util.Optional;

import com.company.pricing.domain.Price;
import com.company.pricing.dto.PriceGetRequest;

public interface PriceService {

  Optional<Price> findPrice(PriceGetRequest priceGetRequest);
}
