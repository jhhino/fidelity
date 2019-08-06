package com.hino.loyalty.resource;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hino.loyalty.domain.Category;
import com.hino.loyalty.domain.PurchaseOrder;
import com.hino.loyalty.dto.CategoryDTO;
import com.hino.loyalty.service.PurchaseOrderService;

@RestController
@RequestMapping(value="/orders")
public class PurchaseOrderResource {
	
	@Autowired
	private PurchaseOrderService purchaseOrderService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PurchaseOrder> find(@PathVariable Integer id) {
		PurchaseOrder purchaseOrder = purchaseOrderService.getPurchaseOrderById(id);
		
		return ResponseEntity.ok().body(purchaseOrder);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PurchaseOrder order) {
		order = purchaseOrderService.insert(order);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(order.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
