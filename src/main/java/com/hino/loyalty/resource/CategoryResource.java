package com.hino.loyalty.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hino.loyalty.domain.Category;
import com.hino.loyalty.service.CategoryService;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	
	private CategoryService categoryService = new CategoryService();

	@RequestMapping(method = RequestMethod.GET)
	public List<Category> list() {
		Category color = new Category(1, "COLOR", "Category for any products as color makup.");
		Category frag = new Category(2, "FRAGRANCE", "Category for any products as parfum/fragrance.");
		
		List<Category> categoryList = new ArrayList<Category>();
		categoryList.add(color);
		categoryList.add(frag);
		
		return categoryList;
	}
	
	public Category getCategory(Integer categoryId) {
		return categoryService.getCategoryById(categoryId);
	}
	}
}
