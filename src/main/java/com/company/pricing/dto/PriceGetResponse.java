package com.company.pricing.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.company.pricing.domain.Currency;
import com.company.pricing.domain.Price;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PriceGetResponse {

  private Integer productId;
  private String brand;
  private Long priceList;
  private String dateTime;
  private String price;
  private Currency currency;

  private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

  public static PriceGetResponse fromPrice(Price price, LocalDateTime dateTime) {

    String priceString =
        String.format("%s.%s", price.getPrice() / 100, price.getPrice() % 100);

    PriceGetResponse response =
        new PriceGetResponse(price.getProduct().getId(), price.getBrand().getName(), price.getPriceList(),
            dateTime.format(formatter), priceString, price.getCurrency());
    return response;
  }

}
