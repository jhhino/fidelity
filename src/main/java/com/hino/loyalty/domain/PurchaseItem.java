package com.hino.loyalty.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class PurchaseItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PurchaseItemPK id = new PurchaseItemPK();
	
	private Double discount;
	private Integer quantity;
	private Double subtotalAmount;
	
	public PurchaseItem() {
		
	}

	public PurchaseItem(PurchaseOrder purchaseOrder, Product product, Double discount, Integer quantity, Double subtotalAmount) {
		super();
		this.id.setOrder(purchaseOrder);
		this.id.setProduct(product);
		this.discount = discount;
		this.quantity = quantity;
		this.subtotalAmount = subtotalAmount;
	}

	public PurchaseItemPK getId() {
		return id;
	}

	public void setId(PurchaseItemPK id) {
		this.id = id;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchaseItem other = (PurchaseItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Double getSubtotalAmount() {
		return subtotalAmount;
	}

	public void setSubtotalAmount(Double subtotalAmount) {
		this.subtotalAmount = subtotalAmount;
	}
	
	// to have straight access to PurchaseOrder
	public PurchaseOrder getPurchaseOrder() {
		return this.getPurchaseOrder();
	}
	
	public Product getProduct() {
		return this.getProduct();
	}
	
	
	
	
	
}
