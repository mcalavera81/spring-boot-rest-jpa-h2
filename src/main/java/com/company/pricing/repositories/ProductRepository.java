package com.company.pricing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.pricing.domain.Brand;
import com.company.pricing.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
