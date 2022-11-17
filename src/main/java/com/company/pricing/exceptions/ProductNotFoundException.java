package com.company.pricing.exceptions;

public class ProductNotFoundException extends RuntimeException{

  public ProductNotFoundException(Integer product) {
    super(String.format("Product '%s' not found",product));
  }

}
