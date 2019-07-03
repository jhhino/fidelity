package com.hino.loyalty.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hino.loyalty.domain.PurchaseOrder;
import com.hino.loyalty.repository.PurchaseOrderRepository;
import com.hino.loyalty.service.exception.ObjectNotFoundException;

@Service
public class PurchaseOrderService {
	
	@Autowired
	private PurchaseOrderRepository PurchaseOrderRepository;

	public PurchaseOrder getPurchaseOrderById(Integer id) {
		Optional<PurchaseOrder> obj = PurchaseOrderRepository .findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"PurchaseOrder not found!** Id: " + id + ", Tipo: " + PurchaseOrder.class.getName()));
	}

}
