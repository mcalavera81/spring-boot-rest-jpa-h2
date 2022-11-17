package com.company.pricing.exceptions;

public class BrandNotFoundException extends RuntimeException{

  public BrandNotFoundException(String brand) {
    super(String.format("Brand '%s' not found",brand ));
  }

}
