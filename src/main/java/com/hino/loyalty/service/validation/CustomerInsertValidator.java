package com.hino.loyalty.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.hino.loyalty.domain.Customer;
import com.hino.loyalty.dto.CustomerNewDTO;
import com.hino.loyalty.repository.CustomerRepository;
import com.hino.loyalty.resource.exception.FieldMessage;

public class CustomerInsertValidator implements ConstraintValidator<CustomerInsert, CustomerNewDTO> {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public void initialize(CustomerInsert ann) {
	}

	@Override
	public boolean isValid(CustomerNewDTO dto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		// validation 
		if (dto.getTier() == 1 && dto.getEmail() == null) {
			list.add(new FieldMessage("email", "Email account missing!!!!!"));
		}
		
		Customer customerByEmail = customerRepo.findByEmail(dto.getEmail());
		if (customerByEmail != null) {
			list.add(new FieldMessage("email", "Duplicated email account!!!!!"));
		}
		
		// framework matters (copy & paste)
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
