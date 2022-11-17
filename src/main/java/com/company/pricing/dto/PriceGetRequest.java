package com.company.pricing.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PriceGetRequest {

  private LocalDateTime dateTime;
  private Integer productId;
  private String brand;

  public PriceGetRequest(LocalDateTime dateTime, Integer productId, String brand) {
    this.dateTime = dateTime;
    this.productId = productId;
    this.brand = brand;
  }
}
