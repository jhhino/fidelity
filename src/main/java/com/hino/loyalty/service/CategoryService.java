package com.hino.loyalty.service;

import java.nio.file.DirectoryIteratorException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hino.loyalty.domain.Category;
import com.hino.loyalty.repository.CategoryRepository;
import com.hino.loyalty.service.exception.DataIntegrityException;
import com.hino.loyalty.service.exception.ObjectNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public Category getCategoryById(Integer id) {
		Optional<Category> obj = categoryRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Category not found!** Id: " + id + ", Tipo: " + Category.class.getName()));
	}

	public Category insert(Category category) {
		category.setId(null);
		return categoryRepository.save(category);
	}

	public Category update(Category category) {
		getCategoryById(category.getId());
		return categoryRepository.save(category);
	}

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public void delete(Integer id) {
		getCategoryById(id);
		try {
			categoryRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Not possible to delete a Category coitaining Products associated.", e);
		}
	}

}
