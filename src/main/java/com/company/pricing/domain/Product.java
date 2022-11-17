package com.company.pricing.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "PRODUCTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

  @Id
  @Column(name = "ID")
  private Integer id;

  @Column(nullable = false, name = "NAME")
  private String name;

}
