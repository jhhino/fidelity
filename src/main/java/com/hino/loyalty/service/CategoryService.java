package com.hino.loyalty.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hino.loyalty.domain.Category;
import com.hino.loyalty.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public Category getCategoryById(Integer id) {
		Optional<Category> obj = categoryRepository .findById(id);
		return obj.orElse(null);
	}

}
