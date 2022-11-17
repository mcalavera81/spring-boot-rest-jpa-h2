package com.company.pricing.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.company.pricing.dto.PriceGetRequest;
import com.company.pricing.dto.PriceGetResponse;
import com.company.pricing.exceptions.PriceNotFoundException;
import com.company.pricing.service.PriceService;

import lombok.RequiredArgsConstructor;
import lombok.val;

@RestController
@RequestMapping(path = "/price")
public class PriceController {

  private PriceService priceService;

  public PriceController(PriceService priceService) {
    this.priceService = priceService;
  }

  @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
  public PriceGetResponse getPrice(@RequestBody PriceGetRequest priceRequest) {
    val price = priceService.findPrice(priceRequest).orElseThrow(() -> new PriceNotFoundException(priceRequest.getBrand(), priceRequest.getProductId()));
    return PriceGetResponse.fromPrice(price, priceRequest.getDateTime());

  }

}
