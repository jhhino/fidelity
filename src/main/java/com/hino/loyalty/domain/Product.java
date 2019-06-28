package com.hino.loyalty.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String skuNumber;
	private String skuName;
	private String brandName;
	private BigDecimal price;
	
	@ManyToOne
	private Category category;
	
	@OneToMany(mappedBy = "id.product")
	private Set<PurchaseItem> purchaseItems = new HashSet<PurchaseItem>();

	public Product() {};
	
	public Product(Integer id, String skuNumber, String skuName, String brandName, BigDecimal price,
			Category category) {
		super();
		this.id = id;
		this.skuNumber = skuNumber;
		this.skuName = skuName;
		this.brandName = brandName;
		this.price = price;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSkuNumber() {
		return skuNumber;
	}

	public void setSkuNumber(String skuNumber) {
		this.skuNumber = skuNumber;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Set<PurchaseItem> getPurchaseItems() {
		return purchaseItems;
	}

	public void setPurchaseItems(Set<PurchaseItem> purchaseItems) {
		this.purchaseItems = purchaseItems;
	}
	
	public List<PurchaseOrder> getPurchaseOrders() {
		List<PurchaseOrder> purchaseOrderList = new ArrayList<PurchaseOrder>();
		for (PurchaseItem item : purchaseItems) {
			purchaseOrderList.add(item.getPurchaseOrder());
		}
		return purchaseOrderList;
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
