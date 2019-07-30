package com.hino.loyalty.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hino.loyalty.domain.Category;
import com.hino.loyalty.domain.Product;
import com.hino.loyalty.domain.PurchaseOrder;
import com.hino.loyalty.repository.CategoryRepository;
import com.hino.loyalty.repository.ProductRepository;
import com.hino.loyalty.service.exception.ObjectNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	public Product find(Integer id) {
		Optional<Product> obj = productRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"PurchaseOrder not found!** Id: " + id + ", Tipo: " + PurchaseOrder.class.getName()));
	}
	
	public Page<Product> search(String skuName, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Category> categoryList = categoryRepository.findAllById(ids);
		return productRepository.search(skuName, categoryList, pageRequest);
		//return productRepository.findDistinctBySkuNameContainingCategoryListIn(skuName, categoryList, pageRequest);
	}
	
}
