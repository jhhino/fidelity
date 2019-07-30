package com.hino.loyalty.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.hino.loyalty.domain.Customer;
import com.hino.loyalty.service.validation.CustomerUpdate;

@CustomerUpdate
public class CustomerDTO implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	private Integer id;
	
	@NotEmpty(message = "Name is required.")
	@Length(min = 5, max=60, message = "Name must have at least 5 characters.")
	private String name;
	
	@NotEmpty(message = "Email account is required.")
	@Email
	private String email;
	
	public CustomerDTO(Customer c) {
		this.id = c.getId();
		this.name = c.getName();
		this.email = c.getEmail();
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
