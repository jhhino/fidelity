package com.hino.loyalty.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hino.loyalty.domain.Customer;
import com.hino.loyalty.repository.CustomerRepository;
import com.hino.loyalty.service.exception.ObjectNotFoundException;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	public Customer getCustomerById(Integer id) {
		Optional<Customer> obj = customerRepository .findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Customer not found!** Id: " + id + ", Tipo: " + Customer.class.getName()));
	}

}
