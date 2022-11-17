package com.company.pricing.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "PRICES")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Price {

  public Price(Long priceList, Brand brand, Product product, LocalDateTime startDate, LocalDateTime endDate,
      Integer priority, Integer price, Currency currency) {
    this.priceList = priceList;
    this.brand = brand;
    this.product = product;
    this.startDate = startDate;
    this.endDate = endDate;
    this.priority = priority;
    this.price = price;
    this.currency = currency;
  }

  /*
   * Identificador de la tarifa de precios aplicable.
   */
  @Id
  @Column(nullable = false, name = "PRICE_LIST")
  private Long priceList;

  /*
   * Foreign key de la cadena del grupo
   */
  @ManyToOne
  @JoinColumn(nullable = false, name = "BRAND_ID")
  private Brand brand;

  /*
   * Identificador código de producto.
   */
  @ManyToOne
  @JoinColumn(nullable = false, name = "PRODUCT_ID")
  private Product product;

  /*
   * Inicio del rango de fechas en el que aplica el precio tarifa indicado
   */
  @Column(nullable = false, name = "START_DATE")
  private LocalDateTime startDate;

  /*
   * Fin del rango de fechas en el que aplica el precio tarifa indicado
   */
  @Column(nullable = false, name = "END_DATE")
  private LocalDateTime endDate;

  /*
   * Desambiguador de aplicación de precios.
   * Si dos tarifas coinciden en un rago de fechas se aplica la de mayor prioridad
   * (mayor valor numérico).
   */
  @Column(nullable = false, name = "PRIORITY")
  private Integer priority;

  /*
   * Precio final de venta.
   */
  @Column(nullable = false, name = "PRICE")
  private Integer price;

  /*
   * ISO de la moneda
   */
  @Column(nullable = false, name = "CURR")
  private Currency currency;

}
