package com.hino.loyalty.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hino.loyalty.domain.Category;
import com.hino.loyalty.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Transactional(readOnly = true)
	@Query("SELECT DISTINCT p FROM Product p INNER JOIN p.categoryList cat WHERE p.skuName LIKE %:skuName% AND cat IN :categoryList")
	Page<Product> search(@Param("skuName") String skuName, @Param("categoryList")List<Category> categoryList, Pageable pageRequest);
	
	//it does the same as method coded above
	//Page<Product> findDistinctBySkuNameContainingCategoryListIn(String skuName, List<Category> categoryList, Pageable pageRequest);

}
