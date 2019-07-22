package com.hino.loyalty.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hino.loyalty.domain.Category;
import com.hino.loyalty.dto.CategoryDTO;
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

	public Category update(Category categoryUpdate) {
		Category category = getCategoryById(categoryUpdate.getId());
		updateData(categoryUpdate, category);
		return categoryRepository.save(category);
	}

	private void updateData(Category categoryUpdate, Category category) {
		category.setName(categoryUpdate.getName());
		
	}

	public void delete(Integer id) {
		getCategoryById(id);
		try {
			categoryRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Not possible to delete a Category coitaining Products associated.", e);
		}
	}
	
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	public Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return categoryRepository.findAll(pageRequest);
	}
	
	public Category fromDTO(CategoryDTO dto) {
		return new Category(dto.getId(), dto.getName(), null);
	}

}
