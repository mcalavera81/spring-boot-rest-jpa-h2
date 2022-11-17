package com.company.pricing.domain;

public enum Currency {
  EUR("€"),USD("$"),CNY("¥");

  private String symbol;

  Currency(String symbol){
    this.symbol = symbol;
  }

  public String getSymbol() {
    return symbol;
  }
}
