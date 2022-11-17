package com.company.pricing.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "BRANDS")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Brand {

  @Id
  @GeneratedValue
  @Column(name = "ID")
  private Long id;

  @Column(nullable = false, name = "NAME")
  private String name;

  public Brand(String name) {
    this.name = name;
  }
}
