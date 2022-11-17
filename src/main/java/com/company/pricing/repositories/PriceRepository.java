package com.company.pricing.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.company.pricing.domain.Brand;
import com.company.pricing.domain.Price;
import com.company.pricing.domain.Product;

public interface PriceRepository extends JpaRepository<Price, Long> {

  @Query("SELECT p FROM Price p WHERE p.brand = :brand and p.product = :product and p.startDate <= :applicationDate and p.endDate >= :applicationDate order by p.priority desc")
  List<Price> findByOrderByPriorityDesc(Brand brand, Product product, LocalDateTime applicationDate);
}
