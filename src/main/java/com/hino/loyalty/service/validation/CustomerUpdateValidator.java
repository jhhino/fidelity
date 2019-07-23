package com.hino.loyalty.service.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.hino.loyalty.domain.Customer;
import com.hino.loyalty.dto.CustomerDTO;
import com.hino.loyalty.repository.CustomerRepository;
import com.hino.loyalty.resource.exception.FieldMessage;

public class CustomerUpdateValidator implements ConstraintValidator<CustomerUpdate, CustomerDTO> {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public void initialize(CustomerUpdate ann) {
	}

	@Override
	public boolean isValid(CustomerDTO dto, ConstraintValidatorContext context) {
		
		//get from request attribute id for customer, since it's not passed via JSON
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer customerIdFromURI = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();

		// validation 		
		Customer customerByEmail = customerRepo.findByEmail(dto.getEmail());
		if (customerByEmail != null && customerByEmail.getId().equals(customerIdFromURI)) {
			list.add(new FieldMessage("email", "Email already associated to another customer!!!!!"));
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
