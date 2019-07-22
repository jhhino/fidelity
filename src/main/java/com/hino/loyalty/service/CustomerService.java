package com.hino.loyalty.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hino.loyalty.domain.Customer;
import com.hino.loyalty.dto.CustomerDTO;
import com.hino.loyalty.repository.CustomerRepository;
import com.hino.loyalty.service.exception.DataIntegrityException;
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

	public Customer update(Customer customerUpdate) {
		Customer customer = getCustomerById(customerUpdate.getId());
		updateData(customerUpdate, customer);
		return customerRepository.save(customer);
	}

	private void updateData(Customer customerUpdate, Customer customer) {
		customer.setName(customerUpdate.getName());
		customer.setEmail(customerUpdate.getEmail());
	}

	public void delete(Integer id) {
		getCustomerById(id);
		try {
			customerRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Not possible to delete a Customer.", e);
		}
	}
	
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	public Page<Customer> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return customerRepository.findAll(pageRequest);
	}
	
	public Customer fromDTO(CustomerDTO dto) {
		return new Customer(dto.getId(), dto.getName(), dto.getEmail(),null);
	}

}
