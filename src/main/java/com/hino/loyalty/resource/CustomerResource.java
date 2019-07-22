package com.hino.loyalty.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hino.loyalty.domain.Customer;
import com.hino.loyalty.dto.CustomerDTO;
import com.hino.loyalty.dto.CustomerNewDTO;
import com.hino.loyalty.service.CustomerService;

@RestController
@RequestMapping(value="/customers")
public class CustomerResource {
	
	@Autowired
	private CustomerService customerService = new CustomerService();

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Customer> find(@PathVariable Integer id) {
		Customer customer = customerService.getCustomerById(id);
		
		return ResponseEntity.ok().body(customer);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CustomerNewDTO customerNewDTO) {
		Customer customer = customerService.fromDTO(customerNewDTO);
		customer = customerService.insert(customer);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(customer.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Customer customer, @PathVariable Integer id) {
		customer = customerService.update(customer);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		customerService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CustomerDTO>> findAll() {
		List<Customer> customerList = customerService.findAll();
		List<CustomerDTO> dtoList = customerList.stream().map(obj -> new CustomerDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtoList);
	}
	
	
}
