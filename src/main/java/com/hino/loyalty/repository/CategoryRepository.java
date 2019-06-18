package com.hino.loyalty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hino.loyalty.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
