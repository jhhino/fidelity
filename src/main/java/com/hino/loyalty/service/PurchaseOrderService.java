package com.hino.loyalty.service;

import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hino.loyalty.domain.BoletoPayment;
import com.hino.loyalty.domain.Product;
import com.hino.loyalty.domain.PurchaseItem;
import com.hino.loyalty.domain.PurchaseOrder;
import com.hino.loyalty.domain.enums.PaymentStatus;
import com.hino.loyalty.repository.PaymentRepository;
import com.hino.loyalty.repository.PurchaseItemRepository;
import com.hino.loyalty.repository.PurchaseOrderRepository;
import com.hino.loyalty.service.exception.ObjectNotFoundException;

@Service
public class PurchaseOrderService {
		
	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PurchaseItemRepository itemRepository;
	
	public PurchaseOrder getPurchaseOrderById(Integer id) {
		Optional<PurchaseOrder> obj = purchaseOrderRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"PurchaseOrder not found!** Id: " + id + ", Tipo: " + PurchaseOrder.class.getName()));
	}

	public @Valid PurchaseOrder insert(@Valid PurchaseOrder order) {
		
		order.setId(null);
		order.setOrderDate(new Date());
		
		order.getPayment().setStatus(PaymentStatus.PENDING);
		order.getPayment().setOrder(order);
		
		if (order.getPayment() instanceof BoletoPayment) {
			BoletoPayment boleto = (BoletoPayment) order.getPayment();
			boletoService.fullfillBoletoPayment(boleto, order.getOrderDate());
		}
		
		order = purchaseOrderRepository.save(order);
		paymentRepository.save(order.getPayment());
		
		for (PurchaseItem item : order.getPurchaseItems()) {
			Product product = productService.find(item.getProduct().getId());
			item.setDiscount(0.00);
			item.setSubtotalAmount(product.getPrice());
			item.setPurchaseOrder(order);
		}
		
		itemRepository.saveAll(order.getPurchaseItems());
		
		return order;
	}

}
