package com.hino.loyalty.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hino.loyalty.domain.PurchaseOrder;
import com.hino.loyalty.service.PurchaseOrderService;

@RestController
@RequestMapping(value="/orders")
public class PurchaseOrderResource {
	
	@Autowired
	private PurchaseOrderService PurchaseOrderService = new PurchaseOrderService();

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		PurchaseOrder PurchaseOrder = PurchaseOrderService.getPurchaseOrderById(id);
		
		return ResponseEntity.ok().body(PurchaseOrder);
	}
	
}
