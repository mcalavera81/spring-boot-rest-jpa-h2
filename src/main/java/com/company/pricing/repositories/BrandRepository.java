package com.company.pricing.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.pricing.domain.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {

  Optional<Brand> findByName(String name);

}
