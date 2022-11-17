package com.company.pricing.exceptions;

public class PriceNotFoundException extends RuntimeException {

  public PriceNotFoundException(String brand, Integer product) {
    super(String.format("Price not found for brand '%s' and product '%s'", brand, product));
  }

}
