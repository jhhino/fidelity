package com.hino.loyalty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hino.loyalty.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
