package com.hino.loyalty.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.hino.loyalty.domain.Category;

public class CategoryDTO {
	
	private Integer id;
	
	@NotEmpty(message = "Mandatory name for category")
	@Length(min=2, max=40, message = "Category's name must contain between 2 and 40 characters")
	private String name;
	
	public CategoryDTO() {
	}
	
	public CategoryDTO(Category category) {
		this.id = category.getId();
		this.name = category.getName();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
